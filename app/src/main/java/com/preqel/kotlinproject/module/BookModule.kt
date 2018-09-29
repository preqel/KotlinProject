package com.preqel.kotlinproject.module

import com.preqel.kotlinproject.NetServcie
import com.preqel.kotlinproject.data.Book
import dagger.Module
import dagger.Provides
import rx.Observable
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by preqel on 2018/9/28.
 * dagger module
 */
@Singleton
@Module
class BookModule{

    constructor()


    @Provides
    @Singleton
    fun provideOne(): Observable<com.preqel.kotlinproject.data.Book> {
//       return  Observable.just(Book("123"));
        return NetServcie.getRetrofit()
    }
}