package HomeScreen

import com.example.latihannavigation01.R


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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



data class listRadio(
    val title: String,
    val Profil: Int,
)

val listStasiun = listOf(
    listRadio(
        title = "With Dewa, Yovie & Nuno,Kerispatih and more",
        Profil = R.drawable.sheila_on_7,
    ),
    listRadio(
        title = "With Payung Teduh, Fiersa Besari, Nadin Amizah and more",
        Profil = R.drawable.fourtwnty,
    ),
    listRadio(
        title = "With Tulus, Bernadya, Hivi! and more",
        Profil = R.drawable.juicyluicy,
    ),
    listRadio(
        title = "With wave to earth, LANY, 88rising and more",
        Profil = R.drawable.nikiradio,
    ),
    listRadio(
        title = "With Nadin Amizah, Juicy Luicy, Sal Priadi and more",
        Profil = R.drawable.bernadyaradio,
    ),
    listRadio(
        title = "With Maroon 5, Katy Perry, Ed Sheeran and more",
        Profil = R.drawable.brunomarsradio,
    ),
)

@Composable
fun stasiun_radio() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding( top = 16.dp)
    ) {
        Text(
            text = "Stasiun Radio yang Direkomendasikan",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(start = 12.dp)

        )
        Spacer(modifier = Modifier.padding(top = 8.dp))

        LazyRow(
            modifier = Modifier
            //.fillMaxWidth()
        ) {
            items(listStasiun.size) { index ->
                val item = listStasiun[index]
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = item.Profil),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .padding(start = 12.dp)
                            .size(160.dp)
                    )

                    Spacer(modifier = Modifier.padding(top = 4.dp))

                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        maxLines = 2,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier

                            .fillMaxWidth()
                            .width(160.dp),
                    )
                }
            }
        }
    }
}


