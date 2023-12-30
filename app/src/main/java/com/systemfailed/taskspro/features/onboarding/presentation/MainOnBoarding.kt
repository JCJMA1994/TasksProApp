package com.systemfailed.taskspro.features.onboarding.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.systemfailed.taskspro.R
import com.systemfailed.taskspro.features.onboarding.data.PageData
import com.systemfailed.taskspro.features.onboarding.presentation.viewmodel.DataStoreViewModel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainOnBoarding(navController: NavController, dataStoreViewModel: DataStoreViewModel) {
    val items = ArrayList<PageData>()
    items.add(
        PageData(
            R.raw.welcome,
            "Tasks Pro",
            "Tus tareas de forma pro"
        )
    )
    items.add(
        PageData(
            R.raw.tasks,
            "Mejor interfaz",
            "Tus tareas de forma pro"
        )
    )

    items.add(
        PageData(
            R.raw.succes,
            "Crea tu cuenta ahora",
            "Tus tareas de forma pro"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )
    OnboardingPager(
        item = items, pagerState = pagerState,
        navController,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        dataStoreViewModel
    )
}