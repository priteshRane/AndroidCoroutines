package com.ransoft.androidcoroutines.simplifiedcoading.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ransoft.androidcoroutines.simplifiedcoading.data.models.Movie
import com.ransoft.androidcoroutines.simplifiedcoading.data.models.Quote
import com.ransoft.androidcoroutines.simplifiedcoading.data.network.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuotesViewModel : ViewModel() {
    private val TAG = "QuoteViewModel"
    val quotes : LiveData<List<Quote>> = MutableLiveData()

    init {
        viewModelScope.launch {
            quotes as MutableLiveData
            quotes.value = getQuotes()

            // Using async
//            val movies = async { getMovies() }
//            val value = movies.await()
        }
    }

    private suspend fun getQuotes(): List<Quote>? {
        return withContext(Dispatchers.IO) {
            android.util.Log.i(TAG, "Getting Quotes")
            MyApi().getQuotes().body()?.quotes
        }
    }

    private suspend fun getMovies(): List<Movie>? {
        return withContext(Dispatchers.IO) {
            android.util.Log.e(TAG, "Getting Movies")
            MyApi().getMovies().body()
        }
    }
}
