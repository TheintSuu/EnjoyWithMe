package com.theintsuhtwe.enjoywithme.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.theintsuhtwe.enjoywithme.data.vos.ActorVO
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.delegate.CreatorItemDelegate
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.item_creator.view.*

class CreatorViewHolder(itemView: View, delegate: CreatorItemDelegate) : BaseViewHolder<ActorVO>(itemView) {

    init {

        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapCreatorItem(it.id!!)
            }
        }
    }

    override fun bindData(data: ActorVO) {
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL+data.profilePath)
            .into(itemView.ivCreatorImage)

        itemView.tvCreatorName.text = data.name.toString()

    }
}