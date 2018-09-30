package com.preqel.kotlinproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.preqel.kotlinproject.R
import com.preqel.kotlinproject.data.Book
import com.preqel.kotlinproject.data.ForeCast
import com.preqel.kotlinproject.data.Weather
import com.preqel.kotlinproject.data.WeatherData

/**
 * Created by preqel on 2018/9/30.
 */
class BookAdpater(private val context: Context, private val data: Array<ForeCast>?) : RecyclerView.Adapter<BookAdpater.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdpater.BookViewHolder {
        return BookViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_item_view, null))
    }

    override fun getItemCount(): Int = data!!.size!!

    override fun onBindViewHolder(holder: BookAdpater.BookViewHolder, position: Int) {
        holder.textview_date.setText(data?.get(position)?.date)
        holder.textview_hign.setText(data?.get(position)?.hign)
        holder.textview_low.setText(data?.get(position)?.low)
        Log.d("preqel","onBindViewHolder ${data?.get(position)?.date}")
    }

    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textview_date: TextView = view.findViewById(R.id.tv_date);

        var textview_hign:TextView = view.findViewById(R.id.tv_hign)

        var textview_low :TextView = view.findViewById(R.id.tv_low)
    }
}