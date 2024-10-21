package com.example.instagramcopy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramcopy.databinding.ItemRv3Binding
import com.example.instagramcopy.models.Data1

class Adapter1(var list: ArrayList<Data1> = ArrayList()): RecyclerView.Adapter<Adapter1.Vh>() {

    inner class Vh(var itemRv3Binding: ItemRv3Binding) :
        RecyclerView.ViewHolder(itemRv3Binding.root) {
        fun onBinding(data1: Data1) {
            itemRv3Binding.img.setImageResource(data1.img)
            itemRv3Binding.txt.text = data1.txt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRv3Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBinding(list[position])
    }
}