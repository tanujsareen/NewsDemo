package `in`.srntech90.doubtnut.ui.list.viewmodel

import `in`.srntech90.doubtnut.ui.common.Output
import `in`.srntech90.doubtnut.ui.list.model.NewsListResponse
import `in`.srntech90.doubtnut.ui.list.repository.ListRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
Created by Tanuj.Sareen on 17,June,2020
 **/
class ListViewModel : ViewModel() {


    private val listRepository = ListRepository()

    private var newsListLiveData = MutableLiveData<Output<NewsListResponse>>()

     fun callNewsAPI(
        country: String?,
        apiKey: String?
    ) {
         newsListLiveData  = listRepository.callNewsList(
                country, apiKey
            )


    }

    fun observeNewsAPI(): MutableLiveData<Output<NewsListResponse>> {
        return newsListLiveData
    }

}