package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.adapter.BaseAdapter
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.delegate.CreatorItemDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.CreatorViewHolder

class CreatorItemAdapter(delegate: CreatorItemDelegate) : BaseAdapter<BaseViewHolder<ActorVO>, ActorVO>() {

    val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ActorVO> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_creator, parent, false)
        return CreatorViewHolder(view, mDelegate)
    }




}