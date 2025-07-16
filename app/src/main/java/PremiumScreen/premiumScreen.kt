package PremiumScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.CoroutineScope

@Composable
fun PremiumScreen(
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    Box(modifier = Modifier
        .background(Color(0xFF121212))
        .fillMaxSize(),
        contentAlignment = Alignment.Center,

        ) {
        Text("Premium Screen")
    }
}