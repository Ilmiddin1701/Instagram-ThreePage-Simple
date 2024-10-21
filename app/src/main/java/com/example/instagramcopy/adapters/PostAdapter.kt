package com.example.instagramcopy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramcopy.databinding.ItemRv2Binding
import com.example.instagramcopy.models.PostData

class PostAdapter(var list: ArrayList<PostData> = ArrayList()): RecyclerView.Adapter<PostAdapter.Vh>() {

    inner class Vh(var itemRv2Binding: ItemRv2Binding) :
        RecyclerView.ViewHolder(itemRv2Binding.root) {
        fun onBinding(postData: PostData) {
            itemRv2Binding.posterImage.setImageResource(postData.posterImage)
            itemRv2Binding.posterName.text = postData.posterName
            itemRv2Binding.posterCountry.text = postData.posterCountry
            itemRv2Binding.postImage.setImageResource(postData.postImage)
            itemRv2Binding.posterName1.text = postData.posterName1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRv2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBinding(list[position])
    }
}