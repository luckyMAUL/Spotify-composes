package NavBarNavigation

import BuatScreen.BuatScreen
import HomeScreen.HomeScreen
import LibraryMusicScreen.KoleksiScreen
import Navigation_Drawer.ProfileScreen
import Navigation_Drawer.SettingsScreen
import PremiumScreen.PremiumScreen
import SearchScreen.SearchScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.latihannavigation01.R
import kotlinx.coroutines.launch


data class DrawerItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

@Preview
@Composable
fun RootNavGraph() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val currentRoute = remember { mutableStateOf("home") }
    val bottomBarRoutes = listOf("home", "search", "koleksi", "premium", "buat")

    // Daftar item drawer
    val drawerItems = listOf(
        DrawerItem("Home", Icons.Default.Home, "home"),
        DrawerItem("Profile", Icons.Default.Person, "profile"),
        DrawerItem("Settings", Icons.Default.Settings, "settings")
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

                Column(
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .background(Color(0xFF121212)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.profil),
                                contentDescription = "Logo",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(75.dp)
                                    .clip(RoundedCornerShape(50.dp))
                                    .clickable {
                                        navController.navigate("profile") {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true

                                            scope.launch {
                                                drawerState.close()
                                            }
                                        }
                                    }
                            )

                            Spacer(modifier = Modifier.padding(start = 8.dp))

                            Column {
                                Text(
                                    "UserGmail@example.com",
                                    style = MaterialTheme.typography.headlineLarge,
                                    color = Color.White,
                                    fontSize = 16.sp,
                                )

                                Text(
                                    "LuckyGGWP",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.White,
                                    fontSize = 16.sp,
                                )
                            }
                    }
                }

                // Menu drawer
                drawerItems.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Image(imageVector = item.icon, contentDescription = null) },
                        label = { Text(item.label) },
                        colors =  NavigationDrawerItemDefaults.colors(
                            selectedIconColor = Color.Green,      // Warna ikon saat aktif
                            unselectedIconColor = Color.Gray,     // Warna ikon saat tidak aktif
                            selectedTextColor = Color.Green,      // Warna teks saat aktif
                            unselectedTextColor = Color.Gray,     // Warna teks saat tidak aktif
                            selectedContainerColor = Color.White      // Background lingkaran di belakang ikon saat aktif
                        ),

                        selected = currentRoute.value == item.route,
                        onClick = {
                            scope.launch { drawerState.close() }
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                launchSingleTop = true
                            }
                            currentRoute.value = item.route
                        },
                    )
                }
            }
        }
    ) {
        Scaffold(
            bottomBar = {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                if (bottomBarRoutes.contains(currentRoute)) {
                    BottomNavigationBar(navController)
                }
            }

        ){ pedding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier
                    .padding(pedding)
            ){
                composable("home") { HomeScreen(scope, drawerState) }
                composable("search") { SearchScreen(scope, drawerState) }
                composable("koleksi") { KoleksiScreen(scope, drawerState) }
                composable("premium") { PremiumScreen(scope, drawerState) }
                composable("buat") { BuatScreen(scope, drawerState) }

                // Drawer Screens
                composable("profile") { ProfileScreen(scope, drawerState) }
                composable("settings") { SettingsScreen(scope, drawerState) }

            }

        }
    }
}

@Composable
fun MyApp() {
   RootNavGraph()
}



