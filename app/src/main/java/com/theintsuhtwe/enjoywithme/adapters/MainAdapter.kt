package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.adapter.BaseAdapter
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.PlayingMoviesVO
import com.theintsuhtwe.enjoywithme.delegate.MovieItemDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.MainViewHolder

class MainAdapter(delegate: MovieItemDelegate): BaseAdapter<BaseViewHolder<PlayingMoviesVO>, PlayingMoviesVO>() {

    val mDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PlayingMoviesVO> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_popular_films_and_series, parent, false)
        return MainViewHolder(view, mDelegate)
    }
}
