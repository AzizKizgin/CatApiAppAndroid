package com.azizkzgn.catapp.util

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.getImage(imageId:String?){

    //https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg

    var imageUrl = "https://cdn2.thecatapi.com/images/${imageId}.jpg"
    Glide.with(context)
        .load(imageUrl)
        .into(this)
}