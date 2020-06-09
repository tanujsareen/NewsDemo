package `in`.srntech90.doubtnut.ui.detail

import `in`.srntech90.doubtnut.R
import `in`.srntech90.doubtnut.databinding.DetailFragBinding
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import timber.log.Timber

class DetailFragment : Fragment() {

    private var contextAttach: Context ? = null

    private var detailBinding: DetailFragBinding ? = null

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
    }

}