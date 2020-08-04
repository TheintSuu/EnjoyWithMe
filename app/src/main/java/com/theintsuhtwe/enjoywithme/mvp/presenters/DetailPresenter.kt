package com.theintsuhtwe.enjoywithme.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.theintsuhtwe.enjoywithme.delegate.ActorItemDelegate
import com.theintsuhtwe.enjoywithme.delegate.CreatorItemDelegate
import com.theintsuhtwe.enjoywithme.mvp.views.DetailView

interface DetailPresenter : ActorItemDelegate, CreatorItemDelegate, BasePresenter<DetailView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)

    fun onTabSelected(lifeCycleOwner: LifecycleOwner, title : String)
}
