package com.preqel.kotlinproject

import com.preqel.kotlinproject.data.Book
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

/**
 * Created by preqel on 2018/9/28.
 */
class NetServcie{

    companion object {
        private val url: String = "www.baidu.com"

        fun getRetrofit (): Observable<Book> {
            val retrofit: Retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(
                    OkHttpClient()
            ).baseUrl(url).build()
            val netpai: NetApi = retrofit.create(NetApi::class.java)
            return netpai.listRepo("user1")


        }
    }

}