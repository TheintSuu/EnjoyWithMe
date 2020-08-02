package com.theintsuhtwe.enjoywithme.network.response

import GetAllMoviesResponse
import com.theintsuhtwe.enjoywithme.utils.API_KEY
import com.theintsuhtwe.enjoywithme.utils.GET_UPCOMING_MOVIES
import io.reactivex.Observable
import retrofit2.http.*

interface MoviesApi {


    @GET(GET_UPCOMING_MOVIES)
    fun getAllMovies(@Query(API_KEY) accessToken : String)
            : Observable<GetAllMoviesResponse>
}