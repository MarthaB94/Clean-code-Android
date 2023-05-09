package com.barryzea.cleancodeapp.domain

import com.barryzea.cleancodeapp.data.Repository
import com.barryzea.cleancodeapp.data.remoteDatasource.entities.Cat

class ImagesUseCase(private val repository: Repository) {
    sealed class ResponseCat{
        class ResponseData(val cats:List<Cat>):ResponseCat()
        class ResponseError(val errorMsg:String):ResponseCat()
    }
    suspend fun getImages(imagesPerPage:Int):ResponseCat{
        val response = repository.getImages(imagesPerPage)
        return if(response.isSuccessful){
            ResponseCat.ResponseData(response.body()!!)
        }else{
            ResponseCat.ResponseError(response.message())
        }
    }
}