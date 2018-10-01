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
class ServcieFactory{

    companion object {

        private val url:String = "http://t.weather.sojson.com"
        //private val url: String = "http://api.map.baidu.com"

        private val url2:String = "http://cdn.sojson.com"

        fun <T> getRetrofit(clazz:Class<T> ): T {
            Log.d("TAG","getNEtService");
            val okHttpClient = OkHttpClient.Builder().addNetworkInterceptor(LoggingInterceptor()).build()
            val retrofit: Retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl(url)
                    .build()
            return  retrofit.create(clazz)
        }


        fun <T> getRetrofit2(clazz: Class<T>):T{
            val okHttpClient = OkHttpClient.Builder().addNetworkInterceptor(LoggingInterceptor()).build()
            val retrofit: Retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl(url2)
                    .build()
            return  retrofit.create(clazz)

        }


    }

}