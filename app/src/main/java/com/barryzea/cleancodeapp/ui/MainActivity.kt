package com.barryzea.cleancodeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.barryzea.cleancodeapp.R
import com.barryzea.cleancodeapp.data.RepositoryImpl
import com.barryzea.cleancodeapp.data.remoteDatasource.Repository
import com.barryzea.cleancodeapp.databinding.ActivityMainBinding
import com.barryzea.cleancodeapp.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()

    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        viewModel.getCats(10)
        viewModel.catImages.observe(this){
            it.forEach {cat->
                Log.d("RESPONSE", cat.toString())
            }
        }

    }
}