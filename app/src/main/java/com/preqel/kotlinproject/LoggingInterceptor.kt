package com.preqel.kotlinproject

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody

/**
 * Created by preqel on 2018/9/28.
 */
class LoggingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        Log.i("TAG","interceptor has been executed" )
        val request: Request = chain.request()
        val t1: Long = System.nanoTime();
        Log.i("TAG", String.format("Sending request ${request.url()}"))
        val respnse = chain.proceed(request)
        val t2: Long = System.nanoTime()
        val respnsebody: ResponseBody = respnse.peekBody(1024 * 2014)
        Log.i("TAG","preqel:" + respnsebody.string())
        return respnse
    }
}