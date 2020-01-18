package com.example.recyclerviewhomework

class ResultListener(val clickListener: (resultId: String) -> Unit) {
    fun onClick(result: Result) = clickListener(result.id)
}