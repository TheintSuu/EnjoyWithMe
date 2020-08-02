package com.theintsuhtwe.enjoywithme.data.model

import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO

interface MoviesModel {
    fun getAllMovies(onError: (String) -> Unit) : LiveData<List<MoviesVO>>

    fun getAllMoviesFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    fun getMoviesById(MoviesId: Int) : LiveData<MoviesVO>
}