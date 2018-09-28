package com.preqel.kotlinproject.module

import com.preqel.kotlinproject.BookActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by preqel on 2018/9/28.
 */
@Singleton
@Component(modules = arrayOf(OneModule::class))
interface OneComponent {
    fun inject(bookactivity: BookActivity)
}