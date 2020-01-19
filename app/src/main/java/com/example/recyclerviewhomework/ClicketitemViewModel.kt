package com.example.recyclerviewhomework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class ClicketitemViewModel(private val database: DownloadedDataDao, application: Application, private val resultId: String) :
    AndroidViewModel(application) {

    val item: Result? = database.get(resultId)

//    private var _clickedItem = MutableLiveData<Result>()
//    var clikedItem = _clickedItem
//    init {
//        initializeClickedItem()
//    }
//
//    private fun initializeClickedItem() {
//        _clickedItem.value = getItemFromDataBase()
//    }
//
//    private fun getItemFromDataBase(): Result? {
//        var item = database.get(resultId)
//        return item
//    }

}


//private val viewModelJob = Job()
//private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
//
//
//init {
//    initializeClickedItem()
//}
//
//private fun initializeClickedItem() {
//    uiScope.launch {
//        clickedItem.value = getItemFromDataBase()
//    }
//}
//
//private suspend fun getItemFromDataBase(): String? {
//    return withContext(Dispatchers.IO){
//        var item = database.getResult()
//    }
//}
//
//override fun onCleared() {
//    super.onCleared()
//    viewModelJob.cancel()
//}