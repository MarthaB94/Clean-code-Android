package com.barryzea.cleancodeapp.data.remoteDatasource.entities

import com.google.gson.annotations.SerializedName

//data class CatEntity(val catList:List<Cat> = arrayListOf())
data class Cat(
    //@SerializedName("breeds") val breeds:List<Breed> = arrayListOf(),
    @SerializedName("id") val id:String="",
    @SerializedName("url")val url:String="",
    @SerializedName("Width") val width:Int=0,
    @SerializedName("height") val height:Int=0

)

