package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.NowPlayingVO


object NowPlayingMovieImpl : BaseModel(), NowPlayingMovieModel {
    @SuppressLint("CheckResult")
    override fun getAllNowPlayingMovieFromApiSaveToDatabase(
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {

    }

    override fun getAllNowPlayingMovieList(onError:(String) ->Unit): LiveData<List<NowPlayingVO>> {
     return  mTheDB.MoviesDao().getAllMovies().to
    }
}