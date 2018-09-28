package com.preqel.kotlinproject.module

import android.util.Log
import com.preqel.kotlinproject.NetServcie
import com.preqel.kotlinproject.data.Book
import dagger.Module
import dagger.Provides
import rx.Observable
import javax.inject.Singleton

/**
 * Created by preqel on 2018/9/28.
 */
  @Singleton
@Module
class OneModule {

    constructor()

    @Singleton
    @Provides
    fun provideOne(): Observable<Book> {
        Log.d("TAG","preqel")
        return NetServcie.getRetrofit()
    }

}