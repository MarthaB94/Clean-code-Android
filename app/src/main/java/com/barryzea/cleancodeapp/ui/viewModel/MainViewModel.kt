package com.barryzea.cleancodeapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barryzea.cleancodeapp.data.remoteDatasource.Repository
import com.barryzea.cleancodeapp.data.remoteDatasource.entities.Cat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel(){

    private var _catImages:MutableLiveData<List<Cat>> = MutableLiveData()
    val catImages:LiveData<List<Cat>>  get() = _catImages

    fun getCats(imagesPerPage:Int){
        viewModelScope.launch {

           _catImages.postValue(repository.getImages(imagesPerPage).body())
        }
    }
}