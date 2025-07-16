package HomeScreen

import com.example.latihannavigation01.R

data class ListLagu(
    val title: String,
    val Profil: Int,
)

val listLagu = listOf(
    ListLagu(
        title = "Lagu yang saya suka",
        Profil = R.drawable.like,
    ),
    ListLagu(
        title = ".Feast",
        Profil = R.drawable.feast,
    ),
    ListLagu(
        title = "Bernadya",
        Profil = R.drawable.bernadya,
    ),
    ListLagu(
        title = "Tulus",
        Profil = R.drawable.tulus,
    ),
    ListLagu(
        title = "Virgoun",
        Profil = R.drawable.vrgoun,
    ),
    ListLagu(
        title = "JKT 48",
        Profil = R.drawable.jkt,
    ),
    ListLagu(
        title = "Budi Doremi",
        Profil = R.drawable.budi_doremi,
    ),
    ListLagu(
        title = "Andmesh",
        Profil = R.drawable.andmesh,
    ),
)