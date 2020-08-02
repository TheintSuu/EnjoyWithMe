package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.TopRatedVO
import com.theintsuhtwe.enjoywithme.data.model.BaseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object TopRatedMovieImpl : BaseModel(),TopRateMovieModel {
    @SuppressLint("CheckResult")
    override fun getTopMovieFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {

    }

    override fun getAllTopMovieList(onError: (String) -> Unit): LiveData<List<TopRatedVO>> {
       return mTheDB.TopRatedVODao().getAllTopRateMovie()
    }
}