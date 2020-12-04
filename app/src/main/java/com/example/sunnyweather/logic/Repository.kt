package com.example.sunnyweather.logic

import androidx.lifecycle.liveData
import com.example.sunnyweather.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

/**
 * Created by ygj on 2020/12/4.
 */
object Repository {

    fun searchPlaces(query: String) =
        liveData(Dispatchers.IO) {
            val result = try {
                val placeResponse = SunnyWeatherNetWork.searchPlace(query)
                if ("ok" == placeResponse.status) {
                    Result.success(placeResponse.places)
                } else {
                    Result.failure(RuntimeException("respone status is ${placeResponse.status}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
            emit(result)
        }
}