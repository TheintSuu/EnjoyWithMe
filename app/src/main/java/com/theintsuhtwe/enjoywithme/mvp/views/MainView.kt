package com.theintsuhtwe.enjoywithme.mvp.views

import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO

interface MainView : BaseView{
    fun displayMoviesList(newsList: List<MoviesVO>)
    fun navigateToMoviesDetails(newsId: Int)

    fun displayMovieListByCaterogry(newsList: List<MoviesVO>)

}