package com.example.instagramcopy.utils

import com.example.instagramcopy.R
import com.example.instagramcopy.models.Data1

object Obj1 {
    val list = ArrayList<Data1>()
    fun add(){
        for (i in 0 until 4){
            list.add(Data1(R.drawable.img1, "Friends"))
            list.add(Data1(R.drawable.img2, "Sport"))
            list.add(Data1(R.drawable.img3, "Design"))
        }
    }
}