package com.theintsuhtwe.enjoywithme.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.enjoywithme.delegate.ActorItemDelegate
import com.theintsuhtwe.enjoywithme.delegate.MovieItemDelegate
import com.theintsuhtwe.enjoywithme.delegate.ShowCaseMovieItemDelegate
import com.theintsuhtwe.enjoywithme.mvp.views.MainView

interface MainPresenter : MovieItemDelegate, ShowCaseMovieItemDelegate, ActorItemDelegate, BasePresenter<MainView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)

    fun onTabSelected(lifeCycleOwner: LifecycleOwner, title : String)
}
