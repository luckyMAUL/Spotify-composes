package Navigation_Drawer

import HomeScreen.HistorySongList
import HomeScreen.ListlaguBar
import HomeScreen.TopScreen.Musik_Screen
import HomeScreen.TopScreen.PodcastScreen
import HomeScreen.stasiun_radio
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TopScreenItem(
    val title: String,
)

val topScreenList = listOf(
    TopScreenItem(
        title = "Semua",
    ),
    TopScreenItem(
        title = "Musik",
    ),
    TopScreenItem(
        title = "Podcast",
    ),
)

@Composable
fun TopScreen(){
    var selectedIndex by remember { mutableStateOf(0) }
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        HomeScreen.topScreenList.forEachIndexed { index, item ->
            val isSelected = index == selectedIndex
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .clickable { selectedIndex = index }
                    .padding(8.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(if (isSelected) Color.Green.copy(alpha = 0.1f) else Color(0xFF121212))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
    when (selectedIndex) {
        0 -> SemuaContent()
        1 -> Musik_Screen()
        2 -> PodcastScreen()
    }
}

@Composable
fun SemuaContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        item { TopScreen() }
        item { ListlaguBar() }
        item { HistorySongList() }
        item { stasiun_radio() }
    }
}