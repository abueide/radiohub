package com.omahacomms.radiohub.ui.components.settings

import com.omahacomms.radiohub.ui.components.settings.app.AppSettingsState
import com.omahacomms.radiohub.ui.components.settings.radio.RadioSettingsState

data class SettingsScreenState(
    val radioSettings: RadioSettingsState = RadioSettingsState(),
    val appSettingsState: AppSettingsState = AppSettingsState(),
)