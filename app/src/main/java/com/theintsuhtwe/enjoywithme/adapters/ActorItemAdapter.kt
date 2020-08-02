package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.adapter.BaseAdapter
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.delegate.ActorItemDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.ActorViewHolder


class ActorItemAdapter(delegate: ActorItemDelegate) : BaseAdapter<BaseViewHolder<MoviesVO>, MoviesVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MoviesVO> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_actor, parent, false)
        return ActorViewHolder(view, mDelegate)
    }




}