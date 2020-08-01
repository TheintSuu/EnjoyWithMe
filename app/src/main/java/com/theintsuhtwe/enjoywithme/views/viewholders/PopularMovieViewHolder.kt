package com.theintsuhtwe.enjoywithme.views.viewholders

import android.graphics.Movie
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.adapters.MovieItemAdapter
import com.theintsuhtwe.enjoywithme.data.vos.PlayingMoviesVO
import com.theintsuhtwe.enjoywithme.delegate.MovieItemDelegate

class PopularMovieViewHolder(itemView: View, delegate: MovieItemDelegate) : BaseViewHolder<PlayingMoviesVO>(itemView) {

    val mDelegate = delegate
   
    private val countryList = mutableListOf<PlayingMoviesVO>()

    private lateinit var mMovieItemAdapter : MovieItemAdapter
   // private lateinit var mPopularMovieListAdapter: PopularMovieListAdapter
    override fun bindData(data: PlayingMoviesVO) {

       // mData = data
        setUpRecycler()


    }

    private fun setUpRecycler() {

    }



}