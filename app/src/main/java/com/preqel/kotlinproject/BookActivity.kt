package com.preqel.kotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.preqel.kotlinproject.data.Book
import com.preqel.kotlinproject.data.Weather
import com.preqel.kotlinproject.module.BookModule
import com.preqel.kotlinproject.module.DaggerBookComponent
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.lang.kotlin.subscribeBy
import rx.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by preqel on 2018/9/28.
 */

class BookActivity:AppCompatActivity{
    constructor() : super()
     @Inject
    lateinit var mBookObservable: Observable<Weather>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
    DaggerBookComponent.builder().bookModule(BookModule()).build().inject(this)
        mBookObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy({
                    Log.d("TAG", "on success executed ${it.time}")
                    Log.d("TAG", "on success executed ${it.cityInfo.city}")

                    it.forecast.forEach {
                        Log.d("TAG","接下来5天的天气 ${it.date} ,最高温度:${it.hign} z最低温度也 ${it.low}")
                    }
                }, {
                    Log.d("TAG", "on failed executed ${it.message}")
                }
        )

    }

}