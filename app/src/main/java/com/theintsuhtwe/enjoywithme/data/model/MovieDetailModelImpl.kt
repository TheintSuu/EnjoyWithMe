package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.data.vos.CastAndCrewVO
import com.theintsuhtwe.enjoywithme.data.vos.MovieDetailVO
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.utils.API_KEY_CODE
import com.theintsuhtwe.enjoywithme.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailModelImpl : BaseModel(), MovieDetailModel {


    override fun getMovieDetailsAndSaveToDatabase(
        movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mMoviesApi.getMovieDetailsById(movieId, API_KEY_CODE)
            .map { it?.let { it } }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.MovieDetailDao().insertMovieDetail(it)
            }, {
                onError(it.localizedMessage ?: "Error")
            })
    }

    override fun getAllPopularPeople(onError: (String) -> Unit): LiveData<List<ActorVO>> {
        TODO("Not yet implemented")
    }

    override fun getMovieDetails(id: Int, onError: (String) -> Unit): LiveData<MovieDetailVO> {
        return mTheDB.MovieDetailDao().getMovieById(id)
    }

    override fun getAllActors(onError: (String) -> Unit): LiveData<List<ActorVO>> {
        return mTheDB.ActorsDao().getAllActor()
    }

    @SuppressLint("CheckResult")
    override fun getAllCastAndCrewFromApiSaveDataBase(
        id: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mMoviesApi.getCastAndCrew(id, API_KEY_CODE)
            .map {
                it
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.CrewAndCrewDao().insertCast(it)
            }, {
                onError(it.localizedMessage ?: "Error")
            })
    }

    override fun getAllCastAndCrew(id: Int, onError: (String) -> Unit): LiveData<CastAndCrewVO> {
        return mTheDB.CrewAndCrewDao().getCastById(id)
    }
}