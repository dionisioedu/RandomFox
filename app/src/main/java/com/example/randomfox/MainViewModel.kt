package com.example.randomfox

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomfox.models.FoxModel
import com.example.randomfox.network.FoxApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _random_fox = MutableLiveData<FoxModel>()

    val random_fox : LiveData<FoxModel>
        get() = _random_fox

    init {
        nextFox()
    }

    fun nextFox() {
        viewModelScope.launch {
            try {
                val newValue = FoxApi.retrofitService.getRandomFox()

                _random_fox.postValue(newValue)

            } catch (e: Exception) {
                Log.e("nextFox", e.message.toString())
            }
        }
    }
}