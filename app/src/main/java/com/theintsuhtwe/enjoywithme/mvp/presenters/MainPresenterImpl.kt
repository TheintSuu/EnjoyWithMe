package com.theintsuhtwe.enjoywithme.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.theintsuhtwe.enjoywithme.data.model.MoviesModel
import com.theintsuhtwe.enjoywithme.data.model.MoviesModelImpl
import com.theintsuhtwe.enjoywithme.mvp.views.MainView

class MainPresenterImpl() : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mMoviesModel  = MoviesModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        requestAllMovies(lifeCycleOwner)
    }

    override fun onTabSelected(lifeCycleOwner: LifecycleOwner, title: String) {
        requestAllMoviesByCategory(lifeCycleOwner, title)
    }

    override fun onTapMovieItem(name: String, value: Int) {

    }

    override fun onTapActorItem(name: String, value: Int) {

    }

    private fun requestAllMovies(lifeCycleOwner: LifecycleOwner) {

        mMoviesModel.getAllMovies (onError = {
           // mView?.disableSwipeRefresh()
            // mView?.displayEmptyView()
        }).observe(lifeCycleOwner, Observer {
           // mView?.disableSwipeRefresh()
            //  if (it.isEmpty()) mView?.displayEmptyView() else mView?.displayNewsList(it)
            mView?.displayMoviesList(it)
        })
    }

    private fun loadAllMoviesFromApi(){

    }

    private fun requestAllMoviesByCategory(lifeCycleOwner: LifecycleOwner, title: String) {

    }



}