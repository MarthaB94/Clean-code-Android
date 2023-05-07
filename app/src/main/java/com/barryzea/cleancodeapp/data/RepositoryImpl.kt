package com.barryzea.cleancodeapp.data

import com.barryzea.cleancodeapp.common.Constants
import com.barryzea.cleancodeapp.data.remoteDatasource.ApiClient
import com.barryzea.cleancodeapp.data.remoteDatasource.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl(private val api:ApiClient): Repository {
    override suspend fun getImages(imagesPerPage: Int) = withContext(Dispatchers.IO){
       api.getImages(imagesPerPage,Constants.API_KEY)
    }
}