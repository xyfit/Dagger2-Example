package com.example.roomexample.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger2example.databinding.ItemLyBinding
import com.example.restapiexample.models.MovieModel
import com.squareup.picasso.Picasso

class ListAdapter: RecyclerView.Adapter<ListAdapter.ItemHolder>() {
    var baseList = emptyList<MovieModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var onItemClickListener: ((MovieModel) -> Unit)? = null
    fun setOnItemClickListener(listener: ((MovieModel) -> Unit)? = null) {
        onItemClickListener = listener
    }

    inner class ItemHolder(val b: ItemLyBinding): RecyclerView.ViewHolder(b.root){
        fun bind(itemData: MovieModel){
            Picasso.get().load(itemData.imageUrl).into(b.imgId)
            b.nameId.text = itemData.name
            b.descId.text = itemData.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(ItemLyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
       holder.bind(baseList[position])
    }

    override fun getItemCount(): Int  = baseList.size
}