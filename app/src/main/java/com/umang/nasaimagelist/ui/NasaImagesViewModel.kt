package com.umang.nasaimagelist.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umang.nasaimagelist.data.NasaRepository
import com.umang.nasaimagelist.models.ImageItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Nasa Images view model
 *
 * @property nasaRepository
 */
@HiltViewModel
class NasaImagesViewModel @Inject constructor(
    private val nasaRepository: NasaRepository
) :
    ViewModel() {
    val nasaImageList = MutableLiveData<List<ImageItem>>()
    var progressStatus = MutableLiveData(true) // progressbar status

    /**
     * Get nasa image list from DataSource
     *
     */
    fun getNasaImageList() {
        viewModelScope.launch(Dispatchers.IO) {
            progressStatus.postValue(true)
            nasaImageList.postValue(nasaRepository.getBaseList())
            progressStatus.postValue(false)
        }
    }

}