package com.umang.nasaimagelist.data

import android.content.Context
import com.google.gson.Gson
import com.umang.nasaimagelist.models.ImageItem
import com.umang.nasaimagelist.models.ImagesResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Fetches data from json file
 */
@Singleton
class NasaDataSource @Inject constructor(@ApplicationContext private val context: Context) {

    private var baseList: List<ImageItem>? = null


    private fun parseListFromFile(): List<ImageItem> {
        val jsonFileString = getJsonDataFromAsset()
        return Gson().fromJson(jsonFileString, ImagesResponse::class.java)
    }

    /**
     * For first time fetch data from json file.For next requests use stored list.
     */
    fun getBaseList(): List<ImageItem>? {
        if (baseList == null)
            baseList = parseListFromFile()
        return baseList
    }

    private fun getJsonDataFromAsset(): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open("data.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }


}