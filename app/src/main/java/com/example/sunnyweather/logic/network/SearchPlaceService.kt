package com.example.sunnyweather.logic.network

import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ygj on 2020/12/4.
 * 彩云 请求搜索城市
 */
interface SearchPlaceService {

    @GET(("/v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN"))
    fun searchPlaces(@Query("query") query: String):Call<PlaceResponse>
}