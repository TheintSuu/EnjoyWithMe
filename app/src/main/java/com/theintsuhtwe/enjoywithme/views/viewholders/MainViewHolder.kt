package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.adapters.MovieItemAdapter
import com.theintsuhtwe.enjoywithme.data.vos.PlayingMoviesVO
import com.theintsuhtwe.enjoywithme.delegate.MovieItemDelegate
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainViewHolder(itemView: View, delegate: MovieItemDelegate) : BaseViewHolder<PlayingMoviesVO>(itemView) {

    val mDelegate = delegate


    private val movieList = mutableListOf<PlayingMoviesVO>()

    private lateinit var mAdapter: MovieItemAdapter

    override fun bindData(data: PlayingMoviesVO) {

        mData = data


        setUpRecycler()





    }

        private fun setUpRecycler(){

        mAdapter =  MovieItemAdapter(mDelegate)
        val linearLayoutManager = LinearLayoutManager(itemView.rvPopularMovies.context,LinearLayoutManager.HORIZONTAL,false)
        itemView.rvPopularMovies.layoutManager = linearLayoutManager
        itemView.rvPopularMovies.adapter = mAdapter


    }


}