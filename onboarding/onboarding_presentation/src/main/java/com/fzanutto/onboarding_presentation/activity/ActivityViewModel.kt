package com.fzanutto.onboarding_presentation.activity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fzanutto.core.domain.model.ActivityLevel
import com.fzanutto.core.domain.preferences.Preferences
import com.fzanutto.core.navigation.Route
import com.fzanutto.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    var selectedActivity by mutableStateOf<ActivityLevel>(ActivityLevel.Medium)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onActivityLevelSelect(activity: ActivityLevel) {
        selectedActivity = activity
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveActivityLevel(selectedActivity)
            _uiEvent.send(UiEvent.Navigate(Route.GOAL))
        }
    }
}