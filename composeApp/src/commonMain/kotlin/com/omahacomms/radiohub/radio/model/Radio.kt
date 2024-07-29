package com.omahacomms.radiohub.radio.model

import kotlinx.coroutines.flow.StateFlow

data class RadioMetaData(
    val name: String,
    val serial: String,
)