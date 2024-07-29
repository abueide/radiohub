package com.omahacomms.radiohub.ui.components.radioConnect

import androidx.lifecycle.ViewModel
import com.omahacomms.radiohub.radio.api.RadioServer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RadioConnectViewModel() : ViewModel(), KoinComponent  {
    val radioServer: RadioServer by inject()

    val connected = radioServer.connected

    fun connect() = radioServer.connect()
    fun disconnect() = radioServer.disconnect()
}