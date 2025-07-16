package SearchScreen

import HomeScreen.listLagu
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.grid.*
import androidx.wear.compose.material.Text



data class ListJelah(
    val title: String,
    val background: Color
)

val listJelah = listOf(
    ListJelah(
        title = "Musik",
        background = Color(0xFFE91487)
    ),
    ListJelah(
        title = "Podcast",
        background = Color(0xFF1E5A51)
    ),
    ListJelah(
        title = "Acara Langsung",
        background = Color(0xFF8D35FF)
    ),
    ListJelah(
        title = "K-Pop",
        background = Color(0xFF375EFF)
    ),
)



@Preview
@Composable
fun MusikJelah() {
    val leftColumn = listJelah.take(2)
    val rightColumn = listJelah.drop(2)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(
            text = "Mulai jelajahi",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                leftColumn.forEach { jelajah ->
                    jelahItem(jelajah)
                }
            }

            Spacer(modifier = Modifier.width(4.dp))

            Column(modifier = Modifier.weight(1f)) {
                rightColumn.forEach { jelajah ->
                    jelahItem(jelajah)
                }
            }
        }
    }
}

    @Composable
    fun jelahItem(jelajah: ListJelah) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .background(jelajah.background)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = jelajah.title,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }