package com.preqel.kotlinproject.module

import com.preqel.kotlinproject.BookActivity
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by preqel on 2018/9/28.
 */
@Singleton
@Component(modules = arrayOf(BookModule::class))
interface BookComponent {
    fun inject(bookActivity: BookActivity)
}