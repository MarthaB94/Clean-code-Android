package com.barryzea.cleancodeapp.data

import com.barryzea.cleancodeapp.data.remoteDatasource.entities.Cat
import retrofit2.Response
interface Repository {
    suspend fun getImages(imagesPerPage:Int):Response<List<Cat>>
}