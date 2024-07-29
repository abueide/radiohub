package com.omahacomms.radiohub.ui.components.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.omahacomms.radiohub.ui.components.channelSelect.ChannelSelectScreen
import com.omahacomms.radiohub.ui.components.radioConnect.RadioConnectScreen
import com.omahacomms.radiohub.ui.components.settings.SettingsScreen
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import radiohub.composeapp.generated.resources.Res
import radiohub.composeapp.generated.resources.channel_select_title
import radiohub.composeapp.generated.resources.radio_connect_title
import radiohub.composeapp.generated.resources.settings


enum class AppScreens(val title: StringResource) {
    RadioConnect(title = Res.string.radio_connect_title),
    ChannelSelect(title = Res.string.channel_select_title),
    Settings(title = Res.string.settings),
}

@Composable
fun RowScope.NavButton(screen: AppScreens, navController: NavHostController){
    Button(
        onClick = { navController.navigate(screen.name)},
        modifier = Modifier.weight(1f)
    ){
        Text(stringResource(screen.title))
    }
}

@Composable
fun RadioHubAppBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    BottomAppBar(){
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.padding(5.dp)
        ){
            NavButton(AppScreens.RadioConnect, navController)
            NavButton(AppScreens.ChannelSelect, navController)
            NavButton(AppScreens.Settings, navController)
        }
    }
}


@Composable
fun RadioHubApp(
    viewModel: MainScreenViewModel = viewModel { MainScreenViewModel() },
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = AppScreens.valueOf(
        backStackEntry?.destination?.route ?: AppScreens.RadioConnect.name
    )

    Scaffold(
        bottomBar = { RadioHubAppBar( navController ) },
    ) { innerPadding ->

        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = AppScreens.RadioConnect.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = AppScreens.RadioConnect.name) {
                RadioConnectScreen()
            }
            composable(route = AppScreens.ChannelSelect.name) {
                ChannelSelectScreen()
            }
            composable(route = AppScreens.Settings.name) {
                SettingsScreen()
            }
        }
    }
}