package `in`.srntech90.doubtnut.ui.detail

import `in`.srntech90.doubtnut.R
import `in`.srntech90.doubtnut.databinding.DetailFragBinding
import `in`.srntech90.doubtnut.ui.list.model.ArticlesItem
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import timber.log.Timber

class DetailFragment : Fragment() {

    private var contextAttach: Context ? = null

    private var detailBinding: DetailFragBinding ? = null

    private var articlesItem: ArticlesItem ? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contextAttach = context
        Timber.i("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate")
        articlesItem = arguments?.getSerializable("articlesItem") as ArticlesItem
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailBinding= DataBindingUtil.inflate(
            inflater, R.layout.detail_frag,container,false
        )
        Timber.i("onCreateView")
        return detailBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("onActivityCreated")
        contextAttach?.let {context->

            detailBinding?.imageViewDetailF?.let {
                Glide.with(context).load(articlesItem?.urlToImage).into(
                    it
                )
            }

            detailBinding?.textViewHeadDF?.text= articlesItem?.title
            detailBinding?.textViewDescription?.text= articlesItem?.description

        }
    }

}