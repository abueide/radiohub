package com.omahacomms.radiohub.ui.components.main

import com.omahacomms.radiohub.radio.model.RadioMetaData

data class MainScreenState (
    val radio: RadioMetaData = RadioMetaData(
        name = "Future Gadget Labs: Gadget #8 'Phone Microwave' (name subject to change)",
        serial = "El Psy Congroo",
    )
)