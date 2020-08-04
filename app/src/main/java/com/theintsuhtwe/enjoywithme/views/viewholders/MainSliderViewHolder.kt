package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.delegate.MovieSliderDelegate
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_upcoming_view.view.*

class MainSliderViewHolder(itemView: View, delegate: MovieSliderDelegate) : SliderViewAdapter.ViewHolder(itemView) {

    var mData: MoviesVO? = null

    init {
        itemView?.setOnClickListener {
            mData?.let {
                delegate.onTapMovieItem(it.id!!)

            }
        }
    }

        fun bindData(data: MoviesVO) {
            mData = data

            Glide.with(itemView.context)
                .load(IMAGE_BASE_URL + data.posterPath)
                .centerCrop()
                .into(itemView.ivPoster)

            itemView.tvMovieTitle.text = data.title


        }



}