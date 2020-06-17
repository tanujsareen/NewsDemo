package `in`.srntech90.doubtnut.ui.list.repository

import `in`.srntech90.ashdesigns.repository.network.Errors
import `in`.srntech90.doubtnut.ui.common.Output
import `in`.srntech90.doubtnut.ui.common.RetrofitApiService
import `in`.srntech90.doubtnut.ui.list.model.NewsListResponse
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
Created by Tanuj.Sareen on 17,June,2020
 **/
class ListRepository {

     fun callNewsList(
        country: String?,
        apiKey: String?
    ): MutableLiveData<Output<NewsListResponse>> {

        Timber.i("callNewsList: '%s', '%s'", country, apiKey)
        val listLiveData = MutableLiveData<Output<NewsListResponse>>()

        listLiveData.value = Output.loading(true)

        RetrofitApiService.newsApi.getNews(
            country, apiKey
        ).enqueue(object : Callback<NewsListResponse> {
            override fun onFailure(call: Call<NewsListResponse>, t: Throwable) {
                Timber.i("onFailure: '%s'", t.message)
                listLiveData.value = Output.loading(false)
                listLiveData.value = Output.failure(Errors("", t.message.toString()))
            }

            override fun onResponse(
                call: Call<NewsListResponse>,
                response: Response<NewsListResponse>
            ) {

                Timber.i("onResponse '%s'", response.body())
                if (response.isSuccessful && response.code() == 200) {
                    listLiveData.value = Output.loading(false)
                    listLiveData.value = Output.success(response.body()!!)
                } else {
                    listLiveData.value = Output.loading(false)
                    listLiveData.value =
                        Output.failure(Errors(response.code().toString(), response.message()))
                }
            }
        })



        return listLiveData
    }
}