package com.preqel.kotlinproject.data

/**
 * Created by preqel on 2018/9/29.
 */
data class Weather(val time:String,val  cityInfo:CityInfo,val forecast:Array<ForeCast> )