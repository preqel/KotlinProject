package com.preqel.kotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.preqel.kotlinproject.adapter.BookAdpater
import com.preqel.kotlinproject.data.Book
import com.preqel.kotlinproject.data.ForeCast
import com.preqel.kotlinproject.data.Weather
import com.preqel.kotlinproject.data.WeatherData
import com.preqel.kotlinproject.module.BookModule
import com.preqel.kotlinproject.module.DaggerBookComponent
import kotlinx.android.synthetic.main.activity_book.view.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.lang.kotlin.subscribeBy
import rx.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by preqel on 2018/9/28.
 */

class BookActivity:AppCompatActivity {
    constructor() : super()

    @Inject
    lateinit var mBookObservable: Observable<Weather>

    lateinit var mlistview: RecyclerView

    var list: Array<ForeCast>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        DaggerBookComponent.builder().bookModule(BookModule()).build().inject(this)
        initObservable()
        mlistview = findViewById(R.id.mlistview);
        mlistview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    }

    private fun initObservable(){
        mBookObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy({
                    Log.d("TAG", "on success executed ${it.time}")
                    Log.d("TAG", "on success executed ${it.cityInfo.city}")
                    list = it.data.forecast
                    it.data.forecast.forEach {
                        Log.d("TAG","接下来5天的天气 ${it.date} ,最高温度:${it.hign} z最低温度也 ${it.low}")
                    }
                    var bookadapter = BookAdpater(this,list)
                    mlistview.adapter = bookadapter
                    bookadapter.notifyDataSetChanged()
                }, {
                    Log.d("TAG", "on failed executed ${it.message}")
                }
                )
    }

}