package com.example.instagramcopy.db

import com.example.instagramcopy.models.Data2

interface DbInterface {
    fun addVideo(data2: Data2)
    fun showVideos(): List<Data2>
}