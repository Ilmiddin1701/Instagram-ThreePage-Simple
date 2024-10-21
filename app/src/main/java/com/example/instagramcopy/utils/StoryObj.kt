package com.example.instagramcopy.utils

import com.example.instagramcopy.R
import com.example.instagramcopy.models.StoryData

object StoryObj {
    val list = ArrayList<StoryData>()
    fun storyAdd(){
        list.add(StoryData(R.drawable.story, "Your Story"))
        for (i in 0  until 5){
            list.add(StoryData(R.drawable.image1, "karenne"))
            list.add(StoryData(R.drawable.image2, "zackjohn"))
            list.add(StoryData(R.drawable.image3, "kieron_d"))
            list.add(StoryData(R.drawable.image4, "craig_love"))
        }
    }
}