package com.preqel.kotlinproject.data

/**
 * Created by preqel on 2018/9/30.
 */
data class WeatherData(val shidu: String, val pm25: String, val pm10: String, val quality: String, val wendu: String, val forecast: Array<ForeCast>)