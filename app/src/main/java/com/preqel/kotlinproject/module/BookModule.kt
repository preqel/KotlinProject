package com.preqel.kotlinproject.module

import com.preqel.kotlinproject.NetServcie
import com.preqel.kotlinproject.data.MyResponse
import dagger.Module
import dagger.Provides
import rx.Observable
import javax.inject.Singleton

/**
 * Created by preqel on 2018/9/28.
 * dagger module
 */
@Singleton
@Module
class BookModule{
    @Singleton
    @Provides
    fun provideBook(): Observable<MyResponse> {
        return NetServcie.getRetrofit()
    }
}