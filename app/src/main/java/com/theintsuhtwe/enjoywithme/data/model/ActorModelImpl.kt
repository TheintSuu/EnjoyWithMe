package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO


object ActorModelImpl : BaseModel(),ActorModel {

    @SuppressLint("CheckResult")
    override fun getPopularActorFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {

    }

    override fun getAllActorPoster(onError: (String) -> Unit): LiveData<List<ActorVO>> {
        return mTheDB.ActorsDao().getAllActor()
    }
}