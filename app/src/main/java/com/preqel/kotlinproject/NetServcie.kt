package com.preqel.kotlinproject

import android.util.Log
import com.preqel.kotlinproject.data.Book
import com.preqel.kotlinproject.data.Weather
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

        private val url:String = "http://t.weather.sojson.com"
        //private val url: String = "http://api.map.baidu.com"

        fun getRetrofit(): Observable<Weather> {
            Log.d("TAG","getNEtService");
            val okHttpClient = OkHttpClient.Builder().addNetworkInterceptor(LoggingInterceptor()).build()
            val retrofit: Retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl(url)
                    .build()
            val netapi: NetApi = retrofit.create(NetApi::class.java)
            return netapi.getWeather("101210101" )
        }
    }

}