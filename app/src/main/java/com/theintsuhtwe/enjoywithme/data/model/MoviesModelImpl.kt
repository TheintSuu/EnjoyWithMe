package com.theintsuhtwe.enjoywithme.data.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.utils.API_KEY_CODE
import com.theintsuhtwe.enjoywithme.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object MoviesModelImpl : MoviesModel, BaseModel() {

    override fun getAllMovies(onError: (String) -> Unit): LiveData<List<MoviesVO>> {
        return mTheDB.MoviesDao()
            .getAllMovies()
    }

    @SuppressLint("CheckResult")
    override fun getAllMoviesFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mMoviesApi
            .getAllMovies(API_KEY_CODE)
            .map { it.data.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.MoviesDao().insertAllMovies(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })

    }




    override fun getMoviesById(MoviesId: Int): LiveData<MoviesVO> {

        return mTheDB.MoviesDao().getMoviesById(MoviesId)
    }
}