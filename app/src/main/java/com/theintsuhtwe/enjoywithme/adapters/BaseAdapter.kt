package com.example.travelapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.travelapp.view.viewholder.BaseViewHolder

abstract class BaseAdapter<T: BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {

    var mDataList: MutableList<W> = mutableListOf()
    override fun onBindViewHolder(holder: T, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }

    fun setData(data: List<W>) {

        mDataList.clear()
        mDataList.addAll(data)
        notifyDataSetChanged()
    }
}