package com.example.sunnyweather.exception

import android.content.Context

/**
 * Created by ygj on 2020/12/4.
 */
object AppUncaughtExceptionHandler : Thread.UncaughtExceptionHandler {

    private lateinit var applicationContext: Context
    private var mDefaultHandler: Thread.UncaughtExceptionHandler? = null

    fun init(context: Context) {
        applicationContext = context.applicationContext
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(this)
    }


    override fun uncaughtException(t: Thread, e: Throwable) {
        e.printStackTrace()
        mDefaultHandler?.uncaughtException(t,e)
    }
}