package `in`.srntech90.doubtnut.ui.common

import `in`.srntech90.doubtnut.ui.list.model.NewsListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
Created by Tanuj.Sareen on 17,June,2020
 **/
interface ApiInterface {


    @GET("/v2/top-headlines")
       fun getNews(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?
    ) : Call<NewsListResponse>

}