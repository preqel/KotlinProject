package com.preqel.kotlinproject

import com.preqel.kotlinproject.data.City
import retrofit2.http.GET
import rx.Observable

/**
 * Created by preqel on 2018/10/1.
 */
//访问城市的接口
interface CityApi {
    @GET("/_city.json")
    fun getCity () : Observable<Array<City>>
}