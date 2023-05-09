package com.barryzea.cleancodeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.barryzea.cleancodeapp.databinding.ActivityMainBinding
import com.barryzea.cleancodeapp.ui.adapters.CatAdapter
import com.barryzea.cleancodeapp.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()

    private lateinit var bind: ActivityMainBinding
    private lateinit var mLayoutManager:StaggeredGridLayoutManager
    private lateinit var mAdapter:CatAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        initAdapter()
        initObservers()
    }
    private fun initAdapter(){
        mAdapter =CatAdapter()
        mLayoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        bind.rvMain.apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            adapter=mAdapter
        }
    }
    private fun initObservers(){
        viewModel.getCats(20)
        viewModel.catImages.observe(this){
            mAdapter.add(it)
        }
        viewModel.errorMsg.observe(this){msgError->
            Toast.makeText(this@MainActivity, msgError, Toast.LENGTH_SHORT).show()
        }
        viewModel.isLoading.observe(this){ if(!it)bind.pbLoading.visibility= View.GONE }
    }
}