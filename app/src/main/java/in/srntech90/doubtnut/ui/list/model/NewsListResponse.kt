package `in`.srntech90.doubtnut.ui.list.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ArticlesItem(@SerializedName("publishedAt")
                        val publishedAt: String? = "",
                        @SerializedName("author")
                        val author: Any? = null,
                        @SerializedName("urlToImage")
                        val urlToImage: String? = "",
                        @SerializedName("description")
                        val description: String? = "",
                        @SerializedName("source")
                        val source: Source?,
                        @SerializedName("title")
                        val title: String? = "",
                        @SerializedName("url")
                        val url: String? = "",
                        @SerializedName("content")
                        val content: Any? = null) : Serializable


data class NewsListResponse(@SerializedName("totalResults")
                            val totalResults: Int? = 0,
                            @SerializedName("articles")
                            val articles: List<ArticlesItem> = ArrayList(),
                            @SerializedName("status")
                            val status: String? = ""): Serializable


data class Source(@SerializedName("name")
                  val name: String? = "",
                  @SerializedName("id")
                  val id: Any? = null): Serializable


