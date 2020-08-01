package com.theintsuhtwe.enjoywithme.mvp.views

import com.theintsuhtwe.enjoywithme.data.vos.PlayingMoviesVO

interface MainView : BaseView{
    fun displayMoviesList(newsList: List<PlayingMoviesVO>)
    fun navigateToMoviesDetails(newsId: Int)

    fun displayMovieListByCaterogry(newsList: List<PlayingMoviesVO>)

}