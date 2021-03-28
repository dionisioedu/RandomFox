package com.example.randomfox

import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.randomfox.models.FoxModel

//@BindingAdapter("imageUrl")
//fun bindImage(imgView: ImageView, foxModel: FoxModel?) {
//    Log.d("bindImage", "FoxModel : $foxModel")
//
//    foxModel?.image?.let{
//        val imgUri = foxModel.image.toUri().buildUpon().scheme("https").build()
//
//        Log.d("Teste", "bindImage called : $imgUri")
//
//        Glide.with(imgView.context)
//            .load(imgUri)
//            .apply(RequestOptions()
//                .placeholder(R.drawable.logo)
//                .error(R.drawable.crying_fox))
//            .into(imgView)
//    }
//}