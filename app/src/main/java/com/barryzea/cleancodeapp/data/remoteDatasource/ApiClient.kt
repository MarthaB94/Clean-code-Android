package com.barryzea.cleancodeapp.data.remoteDatasource

import com.barryzea.cleancodeapp.data.remoteDatasource.entities.Cat
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiClient {
    @GET("images/search?")
    suspend fun getImages(@Query("limit")limit:Int, @Query("api_key")apiKey:String):Response<List<Cat>>

}