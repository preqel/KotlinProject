package com.preqel.kotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.preqel.kotlinproject.data.Book
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
    lateinit var mBookObservable: Observable<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        DaggerBookComponent.builder().bookModule(BookModule()).build().inject(this)
        Log.d("TAg", "inject success")
        mBookObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy({
                    Log.d("TAG", "on success executed" + it.str)
                }, {
                    Log.d("TAG", "on success executed")
                }
                )




    }

}