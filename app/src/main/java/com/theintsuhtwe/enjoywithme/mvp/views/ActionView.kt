package com.theintsuhtwe.enjoywithme.mvp.views

import com.theintsuhtwe.enjoywithme.data.vos.PlayingMoviesVO

interface ActionView : BaseView{
    fun displayMoviesList(newsList: List<PlayingMoviesVO>)
    fun navigateToMoviesDetails(newsId: Int)

}