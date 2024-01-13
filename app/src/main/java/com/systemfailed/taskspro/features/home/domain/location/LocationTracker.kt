package com.systemfailed.taskspro.features.home.domain.location

import android.location.Location


interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}