package com.barryzea.cleancodeapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barryzea.cleancodeapp.common.loadUrl
import com.barryzea.cleancodeapp.data.remoteDatasource.entities.Cat
import com.barryzea.cleancodeapp.databinding.ItemCatBinding

class CatAdapter:RecyclerView.Adapter<CatAdapter.ViewHolder>() {
    private val catList:MutableList<Cat> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bindView = ItemCatBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(bindView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(catList[position])
    }

    fun add(cats:List<Cat>){
        cats.forEach {
            if (!catList.contains(it)){
                catList.add(it)
                notifyItemInserted(catList.size-1)
            }
        }
    }
    override fun getItemCount() = catList.size

    inner class ViewHolder(private val bindView:ItemCatBinding):RecyclerView.ViewHolder(bindView.root) {
        fun onBind(cat:Cat)= with(bindView){
            ivCat.loadUrl(cat.url)
        }
    }


}