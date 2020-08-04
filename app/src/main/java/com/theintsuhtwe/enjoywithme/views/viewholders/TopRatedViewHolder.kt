package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.data.vos.TopRatedVO
import com.theintsuhtwe.enjoywithme.delegate.TopRatedDelegate
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_popular_films_and_series.view.*

class TopRatedViewHolder(itemView: View, delegate: TopRatedDelegate) : BaseViewHolder<TopRatedVO>(itemView) {



    override fun bindData(data: TopRatedVO) {
       mData = data

        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.poster_path)
            .into(itemView.imgPoster)

        itemView.tvTitle.text = data.title.toString()
        itemView.tvRating.text = data.vote_average.toString()
    }
}