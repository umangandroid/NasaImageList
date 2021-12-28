package com.umang.nasaimagelist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.umang.nasaimagelist.R
import com.umang.nasaimagelist.models.ImageItem


/**
 * Adapter to display Images in grid
 */
class NasaImageListAdapter : RecyclerView.Adapter<NasaImageListViewHolder>() {

    private val nasaImageList = ArrayList<ImageItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaImageListViewHolder {
        return NasaImageListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_nasa_image,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NasaImageListViewHolder, position: Int) {
        holder.bind(nasaImageList[position])
    }

    override fun getItemCount(): Int {
        return nasaImageList.size
    }

    /**
     * Submit list
     *
     * @param list
     */
    fun submitList(list: List<ImageItem>) {
        nasaImageList.clear()
        nasaImageList.addAll(list)
        notifyDataSetChanged()
    }
}

