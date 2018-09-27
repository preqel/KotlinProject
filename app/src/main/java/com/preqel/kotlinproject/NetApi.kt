package com.preqel.kotlinproject

import com.preqel.kotlinproject.data.MyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import rx.Observable

/**
 * Created by preqel on 2018/9/28.
 */
interface NetApi {

        //访问接口
      @GET("user/repo")
      fun listRepo(@Path("user")  user:String): Observable<MyResponse>


}