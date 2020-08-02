package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData

import com.theintsuhtwe.enjoywithme.data.vos.PopularMoviesVO

object PopularMovieImpl : BaseModel(), PopularMovieModel {
    @SuppressLint("CheckResult")
    override fun getAllPopularMovieFromApiSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getAllPopularMovieList(onError: (String) -> Unit): LiveData<List<PopularMoviesVO>> {
        return mTheDB.PopularMoviesDao().getAllTopRateMovie()
    }

    override fun getPosterPath(onError: (String) -> Unit): LiveData<List<PopularMoviesVO>> {
        return mTheDB.PopularMoviesDao().getPosterPath()
    }
}