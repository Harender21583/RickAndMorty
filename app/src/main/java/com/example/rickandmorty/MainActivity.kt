package com.example.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmorty.ui.theme.RickAndMortyTheme
import com.example.rickandmorty.ui.theme.constents.Routes
import com.example.rickandmorty.ui.theme.screens.character_detail_screen.CharacterDetailScreen
import com.example.rickandmorty.ui.theme.screens.home_screen.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                App()
            }
        }
    }
}


@Composable
fun App() {
    val navGraph = rememberNavController()
    NavHost(navController = navGraph, startDestination = Routes.HOME_SCREEN) {
        composable(Routes.HOME_SCREEN) {

            HomeScreen() {
                navGraph.navigate("${Routes.CHARACTER_DETAIL_SCREEN}/${it}")
            }
        }
        composable("${Routes.CHARACTER_DETAIL_SCREEN}/{id}", arguments = listOf(navArgument("id") {
            type = NavType.StringType

        })) {
            CharacterDetailScreen()
        }
    }
}