package com.ransoft.androidcoroutines.simplifiedcoading.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.ransoft.androidcoroutines.R
import com.ransoft.androidcoroutines.databinding.FragmentQuotesBinding
import com.ransoft.androidcoroutines.simplifiedcoading.data.models.Quote
import com.ransoft.androidcoroutines.simplifiedcoading.data.network.MyApi
import com.ransoft.androidcoroutines.simplifiedcoading.data.network.responses.QuotesResponse
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class QuotesFragment : Fragment() {

//    private lateinit var job: Job
//    override val coroutineContext: CoroutineContext
//        get() = job + Dispatchers.Main

    private val quotesAdapter by lazy { QuotesAdapter() }
    private lateinit var binding: FragmentQuotesBinding
    private lateinit var viewModel: QuotesViewModel

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        job = Job()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        job.cancel()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quotes, container, false)
        viewModel = ViewModelProvider(this).get(QuotesViewModel::class.java)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerviewQuotes.adapter = quotesAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            getQuotes()
        }

//        launch {
//            quotesAdapter.quotes = getQuotes()
//        }
    }

    private suspend fun getQuotes(): List<Quote>? {
        return withContext(Dispatchers.IO) { MyApi().getQuotes().body()?.quotes }
    }

//    private fun getQuotes() {
//        MyApi().getQuotes().enqueue(object : Callback<QuotesResponse> {
//            override fun onFailure(call: Call<QuotesResponse>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onResponse(
//                call: Call<QuotesResponse>,
//                response: Response<QuotesResponse>
//            ) {
//                quotesAdapter.quotes = response.body()?.quotes
//            }
//        })
//    }
}