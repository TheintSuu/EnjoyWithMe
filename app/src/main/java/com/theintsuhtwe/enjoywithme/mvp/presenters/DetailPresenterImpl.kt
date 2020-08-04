package com.theintsuhtwe.enjoywithme.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.enjoywithme.data.model.ActorModelImpl
import com.theintsuhtwe.enjoywithme.data.model.MoviesModelImpl
import com.theintsuhtwe.enjoywithme.mvp.views.DetailView


class DetailPresenterImpl() : DetailPresenter , AbstractBasePresenter<DetailView>() {

    private val mMoviesModel  = MoviesModelImpl

    private val mActorModel  = ActorModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        requestAllActors(lifeCycleOwner)
        requestAllCreator(lifeCycleOwner)
    }

    override fun onTabSelected(lifeCycleOwner: LifecycleOwner, title: String) {

    }

    override fun onTapActorItem(value: Int) {

    }

    override fun onTapCreatorItem(value: Int) {

    }




    private fun requestAllActors(lifeCycleOwner: LifecycleOwner) {


    }

    private fun requestAllCreator(lifeCycleOwner: LifecycleOwner) {


    }





}