package com.preqel.kotlinproject

import android.database.Observable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.preqel.kotlinproject.module.BookComponent
import com.preqel.kotlinproject.module.BookModule
import javax.inject.Inject

/**
 * Created by preqel on 2018/9/28.
 */
class BookActivity:AppCompatActivity{


    constructor() : super()

    @Inject
    lateinit var bookObservalbe:Observable<String>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)


    }



}