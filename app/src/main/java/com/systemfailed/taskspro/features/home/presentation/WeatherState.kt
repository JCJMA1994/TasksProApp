package com.systemfailed.taskspro.features.home.presentation

import com.systemfailed.taskspro.features.home.domain.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)