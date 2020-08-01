package com.theintsuhtwe.enjoywithme.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.enjoywithme.mvp.views.MainView

class MainPresenterImpl() : MainPresenter, AbstractBasePresenter<MainView>() {


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

    }

    private fun loadAllMoviesFromApi(){

    }

    private fun requestAllMoviesByCategory(lifeCycleOwner: LifecycleOwner, title: String) {

    }



}