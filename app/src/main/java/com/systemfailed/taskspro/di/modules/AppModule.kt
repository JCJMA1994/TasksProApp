package com.systemfailed.taskspro.di.modules

import android.content.Context
import com.systemfailed.taskspro.features.onboarding.data.StoreOnBoarding
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideStoreOnBoarding(@ApplicationContext context: Context): StoreOnBoarding {
        return StoreOnBoarding(context)
    }
}