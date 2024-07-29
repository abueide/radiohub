package com.omahacomms.radiohub.ui.components.radioConnect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import radiohub.composeapp.generated.resources.Res
import radiohub.composeapp.generated.resources.connect
import radiohub.composeapp.generated.resources.connected
import radiohub.composeapp.generated.resources.disconnect
import radiohub.composeapp.generated.resources.disconnected

@Composable
fun RadioConnectScreen(){
    val viewModel: RadioConnectViewModel = remember { RadioConnectViewModel() }

    val connected by viewModel.connected.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1f))
        if(connected){
            Text(stringResource(Res.string.connected), color = MaterialTheme.colorScheme.primary)
        } else {
            Text(stringResource(Res.string.disconnected), color = MaterialTheme.colorScheme.error)
        }

        Button(onClick = {
            if(connected) viewModel.disconnect() else viewModel.connect()
        }) {
            val text = if(connected) stringResource(Res.string.disconnect) else stringResource(Res.string.connect)
            Text(text)
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}
