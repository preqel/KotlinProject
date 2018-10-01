package com.preqel.kotlinproject

import com.preqel.kotlinproject.data.Book
import com.preqel.kotlinproject.data.Weather
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * Created by preqel on 2018/9/28.
 */
interface WeatherApi {

    //访问接口，获得天气(老的)
    @GET("/telematics/v3/weather?city=CHSH000000&language=zh-chs")
    fun getWeatherOld(@Query("location") location: String, @Query("output") output:String, @Query("ak") ak:String) : Observable<Weather>



    //访问接口，获得天气(新的)
    //path参数为城市代码，具体城市码可以从http://cdn.sojson.com/_city.json 下载
    @GET("/api/weather/city/{path}")
    fun getWeather(@Path("path") path:String ):Observable<Weather>



}