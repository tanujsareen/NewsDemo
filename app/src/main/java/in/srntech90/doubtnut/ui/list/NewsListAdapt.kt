package `in`.srntech90.doubtnut.ui.list

import `in`.srntech90.doubtnut.R
import `in`.srntech90.doubtnut.ui.list.model.ArticlesItem
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_item.view.*

/**
Created by Tanuj.Sareen on 17,June,2020
 **/
class NewsListAdapt(
    private var context: Context,
    private var list: ArrayList<ArticlesItem>,
    private var iCallBack: ICallBack

) : RecyclerView.Adapter<NewsListAdapt.NewsListViewHolder>() {


    class NewsListViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    interface ICallBack{
        fun selectedPosition(articlesItem: ArticlesItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
         val view = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false)
        return  NewsListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.itemView.txtViewNewsHead.text = list[position].title
        Glide.with(context).load(list[position].urlToImage).into(holder.itemView.imageView)
        holder.itemView.txtDescription.text= list[position].description
        holder.itemView.constaintLayoutLItem.setOnClickListener {
            iCallBack.selectedPosition(list[position])
        }
    }
}