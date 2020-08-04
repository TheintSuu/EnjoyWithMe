package com.theintsuhtwe.enjoywithme.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.theintsuhtwe.enjoywithme.data.model.*
import com.theintsuhtwe.enjoywithme.mvp.views.MainView

class MainPresenterImpl() : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mMoviesModel  = MoviesModelImpl
    private val mActorModel  = ActorModelImpl
    private val mShowcaseModel  = NowPlayingMovieImpl
    private val mTopRatedModel  = TopRatedMovieImpl
    private val mPopularMovieModel  = PopularMovieImpl
    private val mGenersModel = GenersModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {

        requestAllMovies(lifeCycleOwner)


    }

    override fun onTabSelected(lifeCycleOwner: LifecycleOwner, title: String) {
        requestAllMoviesByCategory(lifeCycleOwner, title)
    }

    override fun onTapMovieItem(value: Int) {
        mView?.navigateToMoviesDetails(value)
    }

    override fun onTapMovieItem(name: String, value: Int) {

    }

    override fun onTapPopularMovieItem(value: Int) {

    }

    override fun onTapActorItem(value: Int) {

    }


    private fun requestAllMovies(lifeCycleOwner: LifecycleOwner) {

        mMoviesModel.getAllMovies (onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.displayMoviesList(it)
        })


        mPopularMovieModel.getAllPopularMovieList  (onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.dispalyPopularMovieList(it)
        })

        mTopRatedModel.getAllTopMovieList  (onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.displayMovieListByCaterogry(it)
        })

        mTopRatedModel.getTopMovieFromApiSaveToDB(
            onSuccess = {

            },
           onError = {

            }
        )

        mMoviesModel.getAllMoviesFromApiAndSaveToDatabase(
            onSuccess = {

            },
            onError = {

            }
        )

        mPopularMovieModel.getAllPopularMovieFromApiSaveToDatabase(
            onSuccess = {

            },
           onError = {

            }
        )

        mShowcaseModel.getAllNowPlayingMovieFromApiSaveToDatabase(
            onSuccess = {

            },
            onFailure = {

            }
        )

        mActorModel.getPopularActorFromApiSaveToDB(
            onSuccess = {

            },
            onError = {

            }
        )

        mGenersModel.getPopularGenersFromApiSaveToDB(
            onSuccess = {

            },
            onError = {

            }
        )

        mShowcaseModel.getAllNowPlayingMovieList  (onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.dispalyShowCaseMovieList(it)
        })

        mActorModel.getAllActorList (onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.displayAcotrList(it)
        })

        mGenersModel.getAllGenersList (onError = {
        }).observe(lifeCycleOwner, Observer {
            mView?.displayGenersList(it)
        })

    }


    private fun requestAllMoviesByCategory(lifeCycleOwner: LifecycleOwner, title: String) {

    }



}