package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.delegate.ActorItemDelegate
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_actor.view.*
import kotlinx.android.synthetic.main.item_creator.view.*

class ActorViewHolder(itemView: View, delegate: ActorItemDelegate) : BaseViewHolder<ActorVO>(itemView) {

    val mDelegate = delegate

    init {

        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapActorItem(it.id!!)
            }
        }
    }

    override fun bindData(data: ActorVO) {
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.profilePath)
            .into(itemView.ivActorImage)

        itemView.tvActorName.text = data.name.toString()

    }
}