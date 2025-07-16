package HomeScreen



import HomeScreen.TopScreen.Musik_Screen
import HomeScreen.TopScreen.PodcastScreen
import Navigation_Drawer.TopScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.latihannavigation01.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


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
fun HomeScreen(
    scope: CoroutineScope,
    drawerState: DrawerState,
) {
    var selectedIndex by remember { mutableStateOf(0) }

    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF121212))
                .padding(start = 16.dp, top = 8.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.profil),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .size(40.dp)
                    .clickable {
                        scope.launch {
                            drawerState.open()
                        }
                    }
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                topScreenList.forEachIndexed { index, item ->
                    val isSelected = index == selectedIndex
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ){
                                selectedIndex = index }
                            .padding(8.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(if (isSelected) Color.Green.copy(alpha = 0.1f) else Color(0xFF121212))
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        }


        when (selectedIndex) {
            0 -> SemuaContent()
            1 -> Musik_Screen()
            2 -> PodcastScreen()
        }
    }
}


@Composable
fun SemuaContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
    ) {
        item { ListlaguBar() }
        item { HistorySongList() }
        item { stasiun_radio() }
    }
}


