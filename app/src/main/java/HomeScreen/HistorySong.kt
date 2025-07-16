package HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.latihannavigation01.R


data class HistorySong(
    val title: String,
    val artist: String,
    val image: Int,
)

val HistorySongItem = listOf(
    HistorySong(
        title = "Surat Cinta untuk Starla",
        artist = "Virgoun",
        image = R.drawable.vrgoun,
    ),
    HistorySong(
        title = "Monokrom",
        artist = "Tulus",
        image = R.drawable.tulus,
    ),
    HistorySong(
        title = "Nina",
        artist = ".Feast",
        image = R.drawable.nina,
    )
)

@Composable
fun HistorySongList() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Sering kamu putar baru-baru ini",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )

        Spacer(modifier = Modifier.padding(8.dp))

        HistorySongItem.forEachIndexed { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 4.dp)
            ){
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .size(50.dp)
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp)
                ) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                    )
                    Text(
                        text = item.artist,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        fontSize = 14.sp,
                    )
                }
            }
        }


    }
}