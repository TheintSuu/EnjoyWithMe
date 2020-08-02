package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View

import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.adapters.MovieItemAdapter
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.delegate.MovieItemDelegate

class PopularMovieViewHolder(itemView: View, delegate: MovieItemDelegate) : BaseViewHolder<MoviesVO>(itemView) {

    val mDelegate = delegate
   
    private val countryList = mutableListOf<MoviesVO>()

    private lateinit var mMovieItemAdapter : MovieItemAdapter
   // private lateinit var mPopularMovieListAdapter: PopularMovieListAdapter
    override fun bindData(data: MoviesVO) {

       // mData = data
        setUpRecycler()


    }

    private fun setUpRecycler() {

    }



}