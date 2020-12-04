package com.example.sunnyweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ygj on 2020/12/4.
 * Retrofit构建器 单例
 *
 */
object ServiceCreator {

    private const val BASE_URL = "https://api.caiyunapp.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun <T> create(serviceClass: Class<T>) = retrofit.create(serviceClass)


    inline fun <reified T> create() = create(T::class.java)
}