package SearchScreen

import HomeScreen.listLagu
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope


@Composable
fun SearchScreen(
    scope: CoroutineScope,
    drawerState: DrawerState

) {
   LazyColumn(
       modifier = Modifier
           .background(Color(0xFF121212))
           .fillMaxSize(),

   ){
       item {
           topSearch(
               scope = scope,
               drawerState = drawerState
           )
       }
       item {
           MusikJelah()
       }


   }
}