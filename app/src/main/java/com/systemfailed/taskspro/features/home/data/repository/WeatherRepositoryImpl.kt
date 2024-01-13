package com.systemfailed.taskspro.features.home.data.repository

import com.systemfailed.taskspro.features.home.data.mappers.toWeatherInfo
import com.systemfailed.taskspro.features.home.data.remote.WeatherApi
import com.systemfailed.taskspro.features.home.domain.Resource
import com.systemfailed.taskspro.features.home.domain.WeatherInfo
import com.systemfailed.taskspro.features.home.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}