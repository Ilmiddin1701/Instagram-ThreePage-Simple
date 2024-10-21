package com.example.instagramcopy.utils

import com.example.instagramcopy.R
import com.example.instagramcopy.models.PostData

object PosObj {
    val list = ArrayList<PostData>()
    fun postAdd() {
        list.add(PostData(R.drawable.post_image, "joshua_l ☑\uFE0F", "Tokyo, Japan", R.drawable.img, "joshua_l ☑\uFE0F"))
        list.add(PostData(R.drawable.image1, "karenne","Tokyo, Japan", R.drawable.moskva, "karenne"))
        list.add(PostData(R.drawable.image2, "zackjohn","Tokyo, Japan", R.drawable.img, "zackjohn"))
        list.add(PostData(R.drawable.image3, "kieron_d","Tokyo, Japan", R.drawable.img, "kieron_d"))
        list.add(PostData(R.drawable.image4, "craig_love","Tokyo, Japan", R.drawable.img,"craig_love"))
    }
}