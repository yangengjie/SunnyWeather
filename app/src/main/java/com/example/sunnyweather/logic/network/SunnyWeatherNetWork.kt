package com.example.sunnyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Created by ygj on 2020/12/4.
 */
object SunnyWeatherNetWork {

    suspend fun searchPlace(query: String) =
        ServiceCreator.create<SearchPlaceService>().searchPlaces(query).await()

    suspend fun <T> Call<T>.await() =
        suspendCoroutine<T> {
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body == null)
                        it.resumeWithException(RuntimeException("respone body cannot be null"))
                    else
                        it.resume(body)
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    it.resumeWithException(t)
                }

            })
        }

}