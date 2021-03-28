package com.example.randomfox

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.net.toUri
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.TransitionOptions
import com.example.randomfox.databinding.ActivityMainBinding
import java.net.URL
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory




class MainActivity : AppCompatActivity() {

    private val mViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply {
            buttonRandomFox.setOnClickListener {
                mViewModel.nextFox()
            }
            mViewModel.random_fox.observe(this@MainActivity, Observer {
                it?.let {
                    textviewLog.text = it.image

                    Glide.with(this@MainActivity)
                        .load(it.image)
                        .into(imageviewFox)

                }
            })
        }

        setContentView(binding.root)
    }
}