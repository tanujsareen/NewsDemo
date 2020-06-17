package `in`.srntech90.doubtnut.ui.list

import `in`.srntech90.doubtnut.BuildConfig
import `in`.srntech90.doubtnut.R
import `in`.srntech90.doubtnut.databinding.ListFragmentBinding
import `in`.srntech90.doubtnut.ui.common.Output
import `in`.srntech90.doubtnut.ui.list.model.ArticlesItem
import `in`.srntech90.doubtnut.ui.list.model.NewsListResponse
import `in`.srntech90.doubtnut.ui.list.viewmodel.ListViewModel
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import timber.log.Timber

class ListFragment : Fragment(), NewsListAdapt.ICallBack {

    private var listFragBinding: ListFragmentBinding? = null

    private val viewModel by activityViewModels<ListViewModel>()

    private var contextAttach: Context? = null

    private var newsList = ArrayList<ArticlesItem>()

    private var newsListAdapt: NewsListAdapt? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contextAttach = context
        Timber.i("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listFragBinding = DataBindingUtil.inflate(
            inflater, R.layout.list_fragment, container, false
        )
        initListFrag()
        Timber.i("onCreateView")
        return listFragBinding?.root
    }

    private fun initListFrag() {

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("onActivityCreated")
        newsList.clear()
        contextAttach?.let { context ->

            newsListAdapt =
                NewsListAdapt(
                    context, newsList, this
                )

            listFragBinding?.recycleNews?.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            listFragBinding?.recycleNews?.adapter = newsListAdapt

            viewModel.callNewsAPI("in", BuildConfig.API_KEY)
            viewModel.observeNewsAPI().observe(viewLifecycleOwner, Observer {
                setValues(it)
            })
        }

    }

    private fun setValues(output: Output<NewsListResponse>?) {
        when (output) {
            is Output.Progress -> {
                listFragBinding?.progressBarList?.visibility = if (output.loading)
                    View.VISIBLE
                else
                    View.GONE
            }
            is Output.Failure -> Timber.i("Unable to Fetch !!")
            is Output.Success -> {
                if (output.data.articles.isNotEmpty()) {
                    newsList.addAll(output.data.articles)
                    newsListAdapt?.notifyDataSetChanged()
                } else {
                    Timber.i("No Data Found !!")
                }

            }
        }
    }

    override fun selectedPosition(articlesItem: ArticlesItem) {
        val bundle= Bundle()
        bundle.putSerializable("articlesItem",articlesItem)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }


}
