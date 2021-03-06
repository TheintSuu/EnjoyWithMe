package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.adapter.BaseAdapter
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.TopRatedVO
import com.theintsuhtwe.enjoywithme.delegate.ShowCaseMovieItemDelegate
import com.theintsuhtwe.enjoywithme.delegate.TopRatedDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.TopRatedViewHolder

class TopRatedAdapter(delegate: TopRatedDelegate) : BaseAdapter<BaseViewHolder<TopRatedVO>, TopRatedVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_films_and_series,parent,false)
        return TopRatedViewHolder(view, mDelegate)
    }

}