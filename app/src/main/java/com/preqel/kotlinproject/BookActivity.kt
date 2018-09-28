package com.preqel.kotlinproject

import android.database.Observable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.preqel.kotlinproject.data.Book
import com.preqel.kotlinproject.module.BookModule
import com.preqel.kotlinproject.module.DaggerBookComponent
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by preqel on 2018/9/28.
 */
class BookActivity:AppCompatActivity{


    constructor() : super()

     @Inject
    lateinit var mBookObservable:Observable<Book>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        //DaggerBookComponent
        //        DaggerBook.builder()
        //                .oneModule(OneModule(mIdList[position].toInt()))
        //                .build()
        //                .inject(this)


        DaggerBookComponent.builder().bookModule(BookModule()).build().inject(this)
    }



}