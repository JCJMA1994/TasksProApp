package com.systemfailed.taskspro.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf


private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlack,
    onPrimary = PrimaryBlack,
    surface = BottomBar,
    onBackground = OnBackground,
    tertiary = Tertiary

)

// dimens

private val LocalDimens = staticCompositionLocalOf { DefaultsDimens }

@Composable
private fun ProvideDimens(
    dimensions: Dimens,
    content: @Composable () -> Unit
) {
    val dimensionSet = remember { dimensions }
    CompositionLocalProvider(LocalDimens provides dimensionSet, content = content)
}

@Composable
fun TasksProTheme(
    windowSize: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    content: @Composable () -> Unit
) {
    val dimensions = if (windowSize > WindowWidthSizeClass.Compact) TabletDimens else DefaultsDimens
    ProvideDimens(dimensions = dimensions) {
        MaterialTheme(
            colorScheme = LightColorScheme,
            typography = Typography,
            content = content
        )
    }

}

object TasksProTheme {
    val dimens: Dimens
        @Composable
        @ReadOnlyComposable
        get() = LocalDimens.current
}