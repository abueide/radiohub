package com.omahacomms.radiohub.ui.components.settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.stringResource
import radiohub.composeapp.generated.resources.Res
import radiohub.composeapp.generated.resources.settings

@Composable
fun SettingsScreen(){
    Text(stringResource(Res.string.settings))
}
