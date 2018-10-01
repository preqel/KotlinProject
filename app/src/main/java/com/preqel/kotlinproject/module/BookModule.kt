package com.preqel.kotlinproject.module

import com.preqel.kotlinproject.CityApi
import com.preqel.kotlinproject.WeatherApi
import com.preqel.kotlinproject.ServcieFactory
import com.preqel.kotlinproject.data.City
import dagger.Module
import dagger.Provides
import rx.Observable
import javax.inject.Singleton

/**
 * Created by preqel on 2018/9/28.
 * dagger module
 */
@Singleton
@Module
class BookModule{

    constructor()

    @Provides
    @Singleton
    fun provideOne(): Observable<com.preqel.kotlinproject.data.Weather> {
        return ServcieFactory.getRetrofit(WeatherApi::class.java).getWeather("101210101");
    }

    @Provides
    @Singleton
    fun provideTwo(): Observable<Array<City>> {
        return ServcieFactory.getRetrofit2(CityApi::class.java).getCity()
//        return
    }
}