package com.omahacomms.radiohub.radio.api

import co.touchlab.kermit.Logger
import com.omahacomms.radiohub.radio.model.RadioChannel
import com.omahacomms.radiohub.radio.model.RadioZone
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

actual class RadioServer {

    private val _zone = MutableStateFlow<RadioZone?>(null)
    private val _channel = MutableStateFlow<RadioChannel?>(null)
    private val _connected = MutableStateFlow(false)

    actual val zone: StateFlow<RadioZone?> = _zone.asStateFlow()
    actual val channel: StateFlow<RadioChannel?> = _channel.asStateFlow()
    actual val connected: StateFlow<Boolean> = _connected.asStateFlow()

    actual fun connect() {
        Logger.i("Connecting to Radio")
        _connected.value = true
    }

    actual fun disconnect(){
        Logger.i("Disconnecting Radio")
        _connected.value = false
        _zone.value = null
    }

    actual fun changeChannel(
        zone: RadioZone,
        channel: RadioChannel
    ) {
        Logger.i("Changing to zone ${zone.name}, channel ${channel.name}")
        _zone.value = zone
        _channel.value = channel
    }

    actual fun listZones(): List<RadioZone> {
        return listOf(
            RadioZone(0, "AlphaCharlie"),
            RadioZone(1, "BetaZulu"),
            RadioZone(2, "EchoSierra")
        )
    }

    actual fun listChannels(zone: Int): List<RadioChannel> {
        return when(zone) {
            0 -> generateChannels(7)
            1 -> generateChannels(4)
            2 -> generateChannels(24)
            else -> generateChannels(10)
        }
    }

    fun generateChannels(number: Int): List<RadioChannel>{
        return (0..number).map {
            val id =  Random.nextInt(100)
            RadioChannel(id = id, name = "Channel #${id}")
        }
    }
}