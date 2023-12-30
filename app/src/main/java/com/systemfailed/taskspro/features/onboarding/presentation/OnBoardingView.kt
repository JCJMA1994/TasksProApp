package com.systemfailed.taskspro.features.onboarding.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.systemfailed.taskspro.common.components.CustomButtonOnBoarding
import com.systemfailed.taskspro.common.components.CustomIndicator
import com.systemfailed.taskspro.features.onboarding.data.PageData
import com.systemfailed.taskspro.features.onboarding.presentation.viewmodel.DataStoreViewModel

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPager(
    item: List<PageData>,
    pagerState: PagerState,
    navController: NavController,
    modifier: Modifier = Modifier,
    dataStoreViewModel: DataStoreViewModel
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.padding(top = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoaderData(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        image = item[page].image
                    )
                    Text(
                        text = item[page].title,
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = item[page].description,
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp
                    )
                }
            }
            CustomIndicator(size = item.size, curretPage = pagerState.currentPage)
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 120.dp)
        ) {
            CustomButtonOnBoarding(
                currentPage = pagerState.currentPage,
                navController,
                dataStoreViewModel
            )
        }
    }
}