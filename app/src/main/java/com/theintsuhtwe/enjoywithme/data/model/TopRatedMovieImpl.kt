package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.model.BaseModel
import com.theintsuhtwe.enjoywithme.data.model.TopRateMovieModel
import com.theintsuhtwe.enjoywithme.data.vos.TopRatedVO
import com.theintsuhtwe.enjoywithme.utils.API_KEY_CODE
import com.theintsuhtwe.enjoywithme.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object TopRatedMovieImpl : BaseModel(), TopRateMovieModel {
    @SuppressLint("CheckResult")
    override fun getTopMovieFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
        TopRatedMovieImpl.mMoviesApi
            .getAllTopRatedMovies(API_KEY_CODE, "Adventure")
            .map { it.data.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                TopRatedMovieImpl.mTheDB.TopRatedVODao().insertTopRateMovieList(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getAllTopMovieList(onError: (String) -> Unit): LiveData<List<TopRatedVO>> {
       return mTheDB.TopRatedVODao().getAllTopRateMovie()
    }
}