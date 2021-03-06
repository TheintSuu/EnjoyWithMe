package com.theintsuhtwe.enjoywithme.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.enjoywithme.delegate.*
import com.theintsuhtwe.enjoywithme.mvp.views.MainView

interface MainPresenter : MovieSliderDelegate, ShowCaseMovieItemDelegate, ActorItemDelegate, PopularMovieItemDelegate,
    TopRatedDelegate, BasePresenter<MainView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)

    fun onTabSelected(lifeCycleOwner: LifecycleOwner, title : String)
}
