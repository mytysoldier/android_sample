package com.example.screentransition.ui.view

import android.annotation.SuppressLint
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object Entry

@Serializable
object Screen1

@Serializable
object Screen2

@Serializable
object Screen2Child

val topRoutes = listOf("Entry", "Screen1", "Screen2")

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route?.substringAfterLast(".")

    Scaffold(
        bottomBar = {
            if (currentRoute in topRoutes) {
                BottomAppBar(
                    actions = {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            IconButton(
                                onClick = { navController.navigate(Entry) },
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(
                                    Icons.Filled.Home, contentDescription = "EntryScreen",
                                )
                            }
                            IconButton(
                                onClick = { navController.navigate(Screen1) },
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(
                                    Icons.Filled.Build, contentDescription = "Screen1Screen",
                                )
                            }
                            IconButton(
                                onClick = { navController.navigate(Screen2) },
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(
                                    Icons.Filled.Refresh, contentDescription = "Screen2Screen",
                                )
                            }
                        }
                    }
                )
            }
        }
    ) {
        NavHost(navController = navController,
            startDestination = Entry,
            enterTransition = {
                EnterTransition.None
            },
            popEnterTransition = {
                EnterTransition.None
            },
            popExitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(),
                    targetOffsetX = { fullWidth -> -fullWidth }
                )
            }
        ) {
            composable<Entry> { EntryScreen() }
            composable<Screen1> {
                Screen1()
            }
            composable<Screen2> { Screen2(onClickNext = { navController.navigate(Screen2Child) }) }
            composable<Screen2Child>(
                enterTransition = {
                    slideInHorizontally(
                        animationSpec = tween(),
                        initialOffsetX = { fullWidth -> fullWidth }
                    )
                }
            ) { Screen2Child(onClickBack = { navController.popBackStack() }) }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}