package com.example.instagramcopy.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramcopy.databinding.ItemRv4Binding
import com.example.instagramcopy.models.Data2

class Adapter2(var rvAction: RvAction, var list: ArrayList<Data2>): RecyclerView.Adapter<Adapter2.Vh>() {

    inner class Vh(var itemRv4Binding: ItemRv4Binding) : RecyclerView.ViewHolder(itemRv4Binding.root) {
        fun onBinding(data2: Data2) {
            itemRv4Binding.root.setOnClickListener{
                rvAction.itemClick(data2)
            }
            itemRv4Binding.tvItem.text = data2.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRv4Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBinding(list[position])
    }

    interface RvAction {
        fun itemClick(data2: Data2)
    }
}