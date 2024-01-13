package com.systemfailed.taskspro.features.home.domain.repository

import com.systemfailed.taskspro.features.home.domain.Resource
import com.systemfailed.taskspro.features.home.domain.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}