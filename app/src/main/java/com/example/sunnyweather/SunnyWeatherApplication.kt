package com.example.sunnyweather

import android.app.Application
import android.content.Context
import com.example.sunnyweather.exception.AppUncaughtExceptionHandler

/**
 * Created by ygj on 2020/12/4.
 */
class SunnyWeatherApplication : Application() {

    companion object {
        const val TOKEN = "BNBRvBveaD2VfHVI"
        lateinit var context: Context
        lateinit var application: SunnyWeatherApplication
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        application=this
        AppUncaughtExceptionHandler.init(this)
    }

}