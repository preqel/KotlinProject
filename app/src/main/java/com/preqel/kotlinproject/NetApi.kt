package com.preqel.kotlinproject

import com.preqel.kotlinproject.data.Book
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by preqel on 2018/9/28.
 */
interface NetApi {

    //访问接口，获得天气
    @GET("/telematics/v3/weather")
    fun getWeather(@Query("location") location: String, @Query("output") output:String, @Query("ak") ak:String) : Observable<Book>




}