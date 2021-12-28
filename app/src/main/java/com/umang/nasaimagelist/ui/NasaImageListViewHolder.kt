package com.umang.nasaimagelist.ui

import androidx.recyclerview.widget.RecyclerView
import com.umang.nasaimagelist.databinding.ItemNasaImageBinding
import com.umang.nasaimagelist.models.ImageItem

/**
 * ViewHolder for NasaImageListAdapter
 *
 * @property binding
 */

class NasaImageListViewHolder(
    private val binding: ItemNasaImageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageItem) {
            binding.apply {
                nasaImage = item
                executePendingBindings()
            }
        }
    }