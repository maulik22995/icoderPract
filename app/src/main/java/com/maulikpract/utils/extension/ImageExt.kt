package com.maulikpract.utils.extension

import android.graphics.Color.red
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.maulikpract.R


@BindingAdapter("buttonColor")
fun buttonColor(imageView: ImageView,type : Int?){
    when(type){
        0 ->{
            imageView.setBackgroundColor(ContextCompat.getColor(imageView.context,R.color.white))
        }
        1 ->{
            imageView.setBackgroundColor(ContextCompat.getColor(imageView.context,R.color.colorPrimary))
        }
        2 ->{
            imageView.setBackgroundColor(ContextCompat.getColor(imageView.context,R.color.red))
        }
    }
}

@BindingAdapter("coverImage")
fun loadImage(imageView: ImageView,imageUrl : String?){
    Glide.with(imageView.context)
        .setDefaultRequestOptions(RequestOptions().centerCrop())
        .load(imageUrl)
        .centerCrop()
        .into(imageView)
}