package com.rishadbaniya.guideofneb.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rishadbaniya.guideofneb.ui.components.BottomNavigationItem
import com.rishadbaniya.guideofneb.ui.components.BottomNavigationBar

val BOTTOM_NAVIGATION_ITEMS = listOf<BottomNavigationItem>(
    BottomNavigationItem(label = 1, icon = 2, route = "home"),
    BottomNavigationItem(label = 1, icon = 2, route = "tools"),
    BottomNavigationItem(label = 1, icon = 2, route = "books"),
    BottomNavigationItem(label = 1, icon = 2, route = "age"),
    BottomNavigationItem(label = 1, icon = 2, route = "notes"),
    BottomNavigationItem(label = 1, icon = 2, route = "library"),
)


@Composable
fun GuideofNEBApp(){
    val navController = rememberNavController();
    Column {
        AppBar()
        Body(modifier = Modifier.weight(1f), navController = navController)
        BottomNavigationBar(
            items = BOTTOM_NAVIGATION_ITEMS,
            navController = navController,
            showBannerAd = false
        )
  }
}

@Composable
fun Body(
   modifier : Modifier,
   navController : NavHostController

){
    NavHost(navController = navController, startDestination = "home", modifier = modifier){

    }
}


@Composable
fun AppBar(){

}

