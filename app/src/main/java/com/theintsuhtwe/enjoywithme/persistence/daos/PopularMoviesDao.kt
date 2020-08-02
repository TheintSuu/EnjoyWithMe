package com.theintsuhtwe.enjoywithme.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.theintsuhtwe.enjoywithme.data.vos.PopularMoviesVO


@Dao
interface PopularMoviesDao {
    @Query("SELECT * FROM popularMovie")
    fun getAllTopRateMovie() : LiveData<List<PopularMoviesVO>>

    @Query("SELECT * FROM popularMovie WHERE id = :movieId")
    fun getMovieById(movieId :Int) : LiveData<PopularMoviesVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopRateMovie(topRateMovie: PopularMoviesVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopRateMovieList(topRateMovie: List<PopularMoviesVO>)

    @Query("SELECT * FROM popularMovie ORDER BY id Desc LIMIT 5")
    fun getPosterPath():LiveData<List<PopularMoviesVO>>
}