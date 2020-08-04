package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.data.vos.NowPlayingVO
import com.theintsuhtwe.enjoywithme.delegate.ShowCaseMovieItemDelegate
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_popular_films_and_series.view.*
import kotlinx.android.synthetic.main.item_showcase.view.*

class ShowCaseViewHolder(itemView: View, delegate: ShowCaseMovieItemDelegate) : BaseViewHolder<NowPlayingVO>(itemView) {
    val mDelegate = delegate
    override fun bindData(data:NowPlayingVO) {
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.poster_path)
            .into(itemView.ivShowCaseImage)

        itemView.tvMovieTitle.text = data.title.toString()
        itemView.tvDate.text = data.release_date.toString()
    }
}