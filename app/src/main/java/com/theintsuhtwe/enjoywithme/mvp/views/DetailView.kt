package com.theintsuhtwe.enjoywithme.mvp.views

import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO

interface DetailView : BaseView{
    fun displayActorsList(newsList: List<ActorVO>)

    fun displayCreatorsList(newsList: List<ActorVO>)





}