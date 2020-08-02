package com.theintsuhtwe.enjoywithme.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO


interface ActorModel {
    fun getPopularActorFromApiSaveToDB(onSuccess:()->Unit,onError : (String)->Unit)

    fun getAllActorPoster(onError: (String) -> Unit): LiveData<List<ActorVO>>
}