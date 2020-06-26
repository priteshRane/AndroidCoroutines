package com.ransoft.androidcoroutines.simplifiedcoading.data.network.responses

import com.ransoft.androidcoroutines.simplifiedcoading.data.models.Quote

data class QuotesResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)