package com.omahacomms.radiohub.radio.api

import com.omahacomms.radiohub.radio.model.RadioChannel
import com.omahacomms.radiohub.radio.model.RadioZone
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

expect class RadioServer() {

    val zone: StateFlow<RadioZone?>
    val channel: StateFlow<RadioChannel?>
    val connected: StateFlow<Boolean>

    fun connect()

    fun disconnect()

    fun changeChannel(zone: RadioZone, channel: RadioChannel)

    fun listZones(): List<RadioZone>

    fun listChannels(zone: Int): List<RadioChannel>
}