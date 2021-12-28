package com.umang.nasaimagelist.data

import com.umang.nasaimagelist.models.ImageItem
import javax.inject.Inject

/**
 * Multiple Datasource can be placed here to fetch data from data source
 */
class NasaRepositoryImpl @Inject constructor (private val nasaDataSource: NasaDataSource) :
    NasaRepository {

    override suspend fun getBaseList(): List<ImageItem>? {
        return nasaDataSource.getBaseList()
    }
}