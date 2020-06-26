package com.ransoft.androidcoroutines.simplifiedcoading.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ransoft.androidcoroutines.simplifiedcoading.data.models.Quote
import com.ransoft.androidcoroutines.simplifiedcoading.data.network.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuotesViewModel : ViewModel() {
    val quotes : LiveData<List<Quote>> = MutableLiveData()

    init {
        viewModelScope.launch {
            quotes as MutableLiveData
            quotes.value = getQuotes()
        }
    }

    private suspend fun getQuotes(): List<Quote>? {
        return withContext(Dispatchers.IO) { MyApi().getQuotes().body()?.quotes }
    }
}
