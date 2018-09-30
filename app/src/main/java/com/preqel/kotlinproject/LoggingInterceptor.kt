package com.preqel.kotlinproject

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody

/**
 * 日志拦截器
 * Created by preqel on 2018/9/28.
 */
class LoggingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val t1: Long = System.nanoTime();
        Log.i("TAG", String.format("Sending URL: ${request.url()}"))
        val respnse = chain.proceed(request)
//        val t2: Long = System.nanoTime()
//        val respnsebody: ResponseBody = respnse.peekBody(1024 * 2014)
//        Log.i("TAG","preqel:" + respnsebody.string())
        return respnse
        //        val t2: Long = System.nanoTime()
//        val mediatype =  respnse.body().contentType();
//        val responsebody = respnse.body().toString();
//        val respnsebody: ResponseBody = respnse.peekBody(1024 * 2014)
//        Log.i("TAG","preqel Response:" + respnsebody.string())
//        return respnse.newBuilder().body(ResponseBody.create(mediatype,responsebody)).build()
    }
}