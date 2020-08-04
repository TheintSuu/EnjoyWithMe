package com.theintsuhtwe.enjoywithme.activites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.adapters.ActorItemAdapter
import com.theintsuhtwe.enjoywithme.adapters.CreatorItemAdapter
import com.theintsuhtwe.enjoywithme.data.model.MoviesModelImpl
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.mvp.presenters.DetailPresenter
import com.theintsuhtwe.enjoywithme.mvp.presenters.DetailPresenterImpl
import com.theintsuhtwe.enjoywithme.mvp.views.DetailView
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.view_pod_actor.*
import kotlinx.android.synthetic.main.view_pod_actor.view.*
import kotlinx.android.synthetic.main.view_pod_creator.*
import kotlinx.android.synthetic.main.view_pod_creator.view.*

class MovieDetailActivity :BaseActivity(), DetailView {

    companion object {

        const val NEWS_ID_EXTRA = "News Id Extra"

        fun newItent(context: Context, newsId : Int): Intent {
            val intent =  Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(NEWS_ID_EXTRA, newsId)
            return intent
        }
    }

    private lateinit var mAcotradapter: ActorItemAdapter


    private lateinit var mCreatorItemAdapter: CreatorItemAdapter

    private lateinit var mPresenter: DetailPresenter

    private var mNewsModel : MoviesModelImpl = MoviesModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        setUpPresenter()

        setUpRecyclerViews()

        mPresenter.onUiReady(this)
//        val newsId = intent.getIntExtra(NEWS_ID_EXTRA, 0)
//        mNewsModel.getMoviesById(newsId)
//            .observe(this, Observer {
//                it?.let {movie->
//                    bindData(movie)
//                }
//            })
    }

    override fun displayActorsList(newsList: List<ActorVO>) {

    }

    override fun displayCreatorsList(newsList: List<ActorVO>) {

    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerViews(){
        mAcotradapter =  ActorItemAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        detailActorLayout.rvActors.layoutManager = linearLayoutManager
        detailActorLayout.rvActors.adapter =  mAcotradapter

        mCreatorItemAdapter =  CreatorItemAdapter(mPresenter)
        val linearLayoutManager1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        creatorLayout.rvCreators.layoutManager = linearLayoutManager1
        creatorLayout.rvCreators.adapter = mCreatorItemAdapter
    }

    private  fun bindData(news : MoviesVO){
        Glide.with(this)
            .load(IMAGE_BASE_URL+news.posterPath)
            .into(ivMoviesImage)
    }


}