package com.fzanutto.calorytracker.navigation

import androidx.navigation.NavController
import com.fzanutto.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}