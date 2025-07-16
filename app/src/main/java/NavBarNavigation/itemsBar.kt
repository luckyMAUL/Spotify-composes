package NavBarNavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.isSelected
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.navigation.currentBackStackEntryAsState

data class Screen(
    val route: String,
    val icon: ImageVector,
    val label: String,
    val onClick: () -> Unit ={}
)

@Composable
fun BottomNavigationBar(navController: NavController) {

    val interactionSource = remember { MutableInteractionSource() }

    val items = listOf(
        Screen("home", Icons.Filled.Home, "Home"),
        Screen("search", Icons.Filled.Search, "search"),
        Screen("koleksi", Icons.Filled.LibraryMusic, "koleksi"),
        Screen("premium", Icons.Filled.Star, "premium"),
        Screen("buat", Icons.Filled.Add, "buat")
    )

    NavigationBar(containerColor = Color(0xFF1F1F1F)) {
        items.forEach { screen -> // <- screen dideklarasikan di sini
            val isSelected = navController.currentBackStackEntryAsState().value?.destination?.route == screen.route

            NavigationBarItem(
                selected = isSelected,
                onClick = { navController.navigate(screen.route)},
                icon = { Icon(screen.icon, contentDescription = screen.route) },
                label = {
                    Text(
                        screen.label,
                    )
                },

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Green.copy(alpha = 1f),
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.Green.copy(alpha = 1f),
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color(0xFF121212) // Warna latar belakang saat item aktif
                ),
                interactionSource = interactionSource,// untuk melacak interaksi dengan elemen navigasi
            )
        }
    }
}

