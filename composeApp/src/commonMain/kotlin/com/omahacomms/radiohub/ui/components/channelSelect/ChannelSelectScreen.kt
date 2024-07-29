package com.omahacomms.radiohub.ui.components.channelSelect

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ChannelSelectScreen(){
        LazyColumn(
            modifier = Modifier.height(400.dp)
        ) {
            for (i in 0..100) {
                item(i) {
                    Text("Channel $i")
                }
            }
        }
}