import androidx.compose.ui.window.ComposeUIViewController
import com.omahacomms.radiohub.App
import com.omahacomms.radiohub.appModule
import com.omahacomms.radiohub.radio.api.RadioServer
import org.koin.core.context.startKoin
import org.koin.dsl.module

val platformModule = module {
}


fun MainViewController() = {
    startKoin {
        modules(appModule + platformModule)
    }

    ComposeUIViewController { App() }
}