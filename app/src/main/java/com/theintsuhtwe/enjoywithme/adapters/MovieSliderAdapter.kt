package com.theintsuhtwe.enjoywithme.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.travelapp.adapter.BaseAdapter
import com.example.travelapp.view.viewholder.BaseViewHolder
import com.smarteist.autoimageslider.SliderViewAdapter
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.delegate.MovieSliderDelegate
import com.theintsuhtwe.enjoywithme.views.viewholders.MainSliderViewHolder

class MovieSliderAdapter(delegate: MovieSliderDelegate): SliderViewAdapter<MainSliderViewHolder>() {

    val mDelegate = delegate

    private var mData = listOf<MoviesVO>()
    override fun onCreateViewHolder(parent: ViewGroup?): MainSliderViewHolder {
        val view =
            LayoutInflater.from(parent!!.context).inflate(R.layout.item_upcoming_view, parent, false)
        return MainSliderViewHolder(view, mDelegate)
    }

    override fun getCount(): Int {
        return mData.count()
    }

    fun setData(data: List<MoviesVO>){
        mData = data!!
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: MainSliderViewHolder?, position: Int) {
        viewHolder?.bindData(mData[position])
    }
}
