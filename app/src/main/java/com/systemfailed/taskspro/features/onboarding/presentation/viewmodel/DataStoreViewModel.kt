package com.systemfailed.taskspro.features.onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.systemfailed.taskspro.features.onboarding.data.StoreOnBoarding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val store: StoreOnBoarding
) : ViewModel() {
    val getBoarding: Flow<Boolean> = store.getBoarding

    fun saveOnBoarding(value: Boolean) {
        viewModelScope.launch {
            store.saveOnBoarding(value)
        }
    }
}