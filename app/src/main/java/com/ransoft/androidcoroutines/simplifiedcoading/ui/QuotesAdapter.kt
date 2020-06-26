package com.ransoft.androidcoroutines.simplifiedcoading.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ransoft.androidcoroutines.R
import com.ransoft.androidcoroutines.databinding.ItemQuoteBinding
import com.ransoft.androidcoroutines.simplifiedcoading.data.models.Quote

class QuotesAdapter : RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder>() {

    var quotes: List<Quote>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = QuoteViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_quote,
            parent,
            false
        )
    )

    override fun getItemCount() = quotes?.size ?: 0

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.binding.quote = quotes!![position]
    }

    inner class QuoteViewHolder(val binding: ItemQuoteBinding) :
        RecyclerView.ViewHolder(binding.root)
}
