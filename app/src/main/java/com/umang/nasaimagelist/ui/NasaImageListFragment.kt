package com.umang.nasaimagelist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.umang.nasaimagelist.databinding.FragmentNasaImageListBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment to display list of images
 */
@AndroidEntryPoint
class NasaImageListFragment : Fragment() {

    private lateinit var adapter: NasaImageListAdapter
    private lateinit var nasaImageListBinding: FragmentNasaImageListBinding
    private val viewModel: NasaImagesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        nasaImageListBinding =
            FragmentNasaImageListBinding.inflate(inflater, container, false)
        return nasaImageListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nasaImageListBinding.viewModel = viewModel
        nasaImageListBinding.lifecycleOwner = this
        setupAdapter()
        setDataObservers()
        viewModel.getNasaImageList()
    }



    private fun setDataObservers() {
        viewModel.nasaImageList.observe(viewLifecycleOwner, {
            it?.let { nasaImageList ->
                adapter.submitList(nasaImageList)
                nasaImageListBinding.list.scrollToPosition(0)
            }
        })
    }

    private fun setupAdapter() {
        nasaImageListBinding.list.setHasFixedSize(true)
        adapter = NasaImageListAdapter()
        nasaImageListBinding.list.adapter = adapter
    }

}

