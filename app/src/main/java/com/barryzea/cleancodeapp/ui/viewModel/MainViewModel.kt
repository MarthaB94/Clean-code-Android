package com.barryzea.cleancodeapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barryzea.cleancodeapp.data.remoteDatasource.entities.Cat
import com.barryzea.cleancodeapp.domain.ImagesUseCase
import com.barryzea.cleancodeapp.domain.ImagesUseCase.ResponseCat as responseCat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: ImagesUseCase) : ViewModel(){

    private var _catImages:MutableLiveData<List<Cat>> = MutableLiveData()
    private var _errorMsg:MutableLiveData<String> = MutableLiveData()
    private var _isLoading:MutableLiveData<Boolean> = MutableLiveData(true)
    val catImages:LiveData<List<Cat>>  get() = _catImages
    val errorMsg:LiveData<String> get() = _errorMsg
    val isLoading:LiveData<Boolean> get() = _isLoading

    fun getCats(imagesPerPage:Int){
        viewModelScope.launch {
            val response = useCase.getImages(imagesPerPage)
            when(response){
                is responseCat.ResponseData->{
                    _catImages.postValue(response.cats)
                    _isLoading.value=false
                }
                is responseCat.ResponseError->{
                    _errorMsg.postValue(response.errorMsg)

                }
            }

        }
    }
}