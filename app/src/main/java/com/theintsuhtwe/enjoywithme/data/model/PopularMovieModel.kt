package com.theintsuhtwe.enjoywithme.data.model

import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMoviesVO


interface PopularMovieModel {
    fun getAllPopularMovieFromApiSaveToDatabase(onSuccess:()->Unit,onError:(String)->Unit)

    fun getAllPopularMovieList(onError: (String) -> Unit): LiveData<List<PopularMoviesVO>>

    fun getPosterPath(onError: (String) -> Unit):LiveData<List<PopularMoviesVO>>
}