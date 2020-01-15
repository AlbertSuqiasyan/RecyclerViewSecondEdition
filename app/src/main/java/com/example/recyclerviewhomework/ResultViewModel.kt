package com.example.recyclerviewhomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response

class ResultViewModel : ViewModel(){
    private val _response = MutableLiveData<List<Result>>()
    val response: LiveData<List<Result>> = _response
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        getDownloadedProperties()
    }

    private fun getDownloadedProperties() {
        TheApi.retrofitService.getProperties().enqueue(object : retrofit2.Callback<DownloadedData> {
            override fun onFailure(call: Call<DownloadedData>, t: Throwable) {
                _error.value = "error: ${t.message}"
            }

            override fun onResponse(call: Call<DownloadedData>, response: Response<DownloadedData>) {
                _response.value = response.body()?.response?.results
            }
        })
    }
}