package com.omahacomms.radiohub

import androidx.compose.runtime.*
import com.omahacomms.radiohub.radio.api.RadioServer
import com.omahacomms.radiohub.ui.components.channelSelect.ChannelSelectViewModel
import com.omahacomms.radiohub.ui.components.main.RadioHubApp
import com.omahacomms.radiohub.ui.components.radioConnect.RadioConnectScreen
import com.omahacomms.radiohub.ui.components.radioConnect.RadioConnectViewModel
import com.omahacomms.radiohub.ui.components.main.MainScreenViewModel
import com.omahacomms.radiohub.ui.components.settings.SettingsScreenViewModel
import com.omahacomms.radiohub.ui.theme.RadioHubTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val appModule = module {
    singleOf(::RadioServer)
    singleOf(::MainScreenViewModel)
    singleOf(::RadioConnectViewModel)
    singleOf(::ChannelSelectViewModel)
    singleOf(::SettingsScreenViewModel)
}

@Composable
@Preview
fun App() {
    RadioHubTheme {
        RadioHubApp()
    }
}