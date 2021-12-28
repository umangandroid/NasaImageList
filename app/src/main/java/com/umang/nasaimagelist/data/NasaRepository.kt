package com.umang.nasaimagelist.data

import com.umang.nasaimagelist.models.ImageItem


/**
 * To fetch data from NasaDataSource
 */
interface NasaRepository {
    suspend fun getBaseList():  List<ImageItem>?
}