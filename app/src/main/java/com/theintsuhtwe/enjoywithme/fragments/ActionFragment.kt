package com.theintsuhtwe.enjoywithme.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.adapters.ActionTaskAdapter
import com.theintsuhtwe.enjoywithme.adapters.MovieItemAdapter
import com.theintsuhtwe.enjoywithme.data.vos.PlayingMoviesVO
import com.theintsuhtwe.enjoywithme.mvp.presenters.MainPresenter
import com.theintsuhtwe.enjoywithme.mvp.presenters.MainPresenterImpl
import com.theintsuhtwe.enjoywithme.mvp.views.ActionView
import com.theintsuhtwe.enjoywithme.mvp.views.MainView
import kotlinx.android.synthetic.main.fragment_action.*
import kotlinx.android.synthetic.main.fragment_main.*

class ActionFragment : Fragment(), ActionView {

    companion object{
        const val ACTION_FRAGMENT_TAG = "ACTION_FRAGMENT_TAG"

        fun newInstance(): ActionFragment {
            return ActionFragment()
        }
    }

    private lateinit var mAdapter: MovieItemAdapter

    private lateinit var mPresenter : MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_action, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        with(rvAction){

            mAdapter = MovieItemAdapter(mPresenter)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        //mPresenter.initPresenter(this)
    }

    override fun displayMoviesList(newsList: List<PlayingMoviesVO>) {

    }

    override fun navigateToMoviesDetails(newsId: Int) {
        TODO("Not yet implemented")
    }

}