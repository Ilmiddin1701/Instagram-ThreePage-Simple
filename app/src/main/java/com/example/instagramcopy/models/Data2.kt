package com.example.instagramcopy.models

class Data2{
    var id: Int? = null
    var video: String? = null

    constructor(id: Int?, video: String?) {
        this.id = id
        this.video = video
    }

    constructor(video: String?) {
        this.video = video
    }
}