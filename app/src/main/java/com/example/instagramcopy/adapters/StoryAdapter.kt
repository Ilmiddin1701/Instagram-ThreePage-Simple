package com.example.instagramcopy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramcopy.databinding.ItemRv1Binding
import com.example.instagramcopy.models.StoryData

class StoryAdapter(var list: ArrayList<StoryData> = ArrayList()): RecyclerView.Adapter<StoryAdapter.Vh>() {

    inner class Vh(var itemRv1Binding: ItemRv1Binding) : RecyclerView.ViewHolder(itemRv1Binding.root) {
        fun onBinding(storyData: StoryData) {
            itemRv1Binding.storyImage.setImageResource(storyData.image)
            itemRv1Binding.storyName.text = storyData.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRv1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBinding(list[position])
    }
}