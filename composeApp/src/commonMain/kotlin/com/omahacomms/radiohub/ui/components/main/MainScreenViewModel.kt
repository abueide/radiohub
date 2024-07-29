package com.omahacomms.radiohub.ui.components.main

import androidx.lifecycle.ViewModel
import com.omahacomms.radiohub.radio.api.RadioServer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainScreenViewModel() : ViewModel(), KoinComponent {

    val radioServer: RadioServer by inject()

    private val _uiState = MutableStateFlow(MainScreenState())
    val uiState: StateFlow<MainScreenState> = _uiState.asStateFlow()
}