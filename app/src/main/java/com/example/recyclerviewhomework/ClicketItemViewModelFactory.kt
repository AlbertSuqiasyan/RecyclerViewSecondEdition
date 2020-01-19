package com.example.recyclerviewhomework

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ClicketItemViewModelFactory( private val dataSource: DownloadedDataDao, private val application: Application, private val resultId: String) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClicketitemViewModel::class.java)) {
            return ClicketitemViewModel(dataSource, application,resultId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}