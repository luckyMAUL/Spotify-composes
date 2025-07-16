package SearchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class itemClip(
    val title: String,
    val background: Color,
)

val listClip = listOf(
    itemClip(
        title = "Musik",
        background = Color(0xFFE91487)
    ),
    itemClip(
        title = "Podcast",
        background = Color(0xFF1E5A51)
    ),
    itemClip(
        title = "Langsung",
        background = Color(0xFF8D35FF)
    ),
    itemClip(
        title = "K-Pop",
        background = Color(0xFF375EFF)
    ),


)
@Preview
@Composable
fun ClipScreen() {

    LazyRow(
        modifier = Modifier
            .height(64.dp)

    ){

        itemsIndexed(listClip) { index, itemClip ->

            Spacer(modifier = Modifier.padding(start =  8.dp))
            Text(
                text = itemClip.title,
                color = Color.White,
                modifier = Modifier
                    .background(itemClip.background)
                    .height(64.dp)
                    .padding(start = 6.dp, end = 6.dp)

            )
        }
    }
}