package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.bumptech.glide.Glide

import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.data.vos.PopularMoviesVO
import com.theintsuhtwe.enjoywithme.delegate.MovieSliderDelegate
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_popular_films_and_series.view.*

class PopularMovieViewHolder(itemView: View, delegate: MovieSliderDelegate) : BaseViewHolder< PopularMoviesVO>(itemView) {

    val mDelegate = delegate

    init{
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapMovieItem(it.id)
            }
        }
    }
    override fun bindData(data: PopularMoviesVO) {
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.poster_path)
            .into(itemView.imgPoster)

        itemView.tvTitle.text = data.title.toString()
        itemView.tvRating.text = data.vote_average.toString()

    }


}