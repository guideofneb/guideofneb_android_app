package com.rishadbaniya.guideofneb.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rishadbaniya.guideofneb.ui.components.BottomNavigationItem
import com.rishadbaniya.guideofneb.ui.components.BottomNavigationBar
import com.rishadbaniya.guideofneb.R;

val BOTTOM_NAVIGATION_ITEMS = listOf<BottomNavigationItem>(
    BottomNavigationItem(label = "Home" , icons = listOf(HOME_LINE, HOME_FILL), route = "home"),
    BottomNavigationItem(label = "Notes" , icons = listOf(NOTES_LINE, NOTES_FILL), route = "notes"),
    BottomNavigationItem(label = "Solutions" , icons = listOf(SOLUTIONS_LINE, SOLUTIONS_FILL), route = "solutions"),
    BottomNavigationItem(label = "Tools", icons = listOf(TOOLS_LINE, TOOLS_FILL), route = "tools"),
    BottomNavigationItem(label = "News" , icons = listOf(NEWS_LINE, NEWS_FILL), route = "news"),
    BottomNavigationItem(label = "Library", icons = listOf(STACK_LINE, STACK_FILL), route = "library"),
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
    Text("BODY", modifier = modifier)
    NavHost(navController = navController, startDestination = "home", modifier = modifier){
        composable("home"){
            Text("YO")
        }
        composable("notes"){
            Text("YO")
        }
        composable("solutions"){
            Text("YO")
        }
        composable("tools"){
            Text("YO")
        }
        composable("news"){
            Text("YO")
        }
        composable("library"){
            Text("YO")
        }
    }
}


@Composable
fun AppBar(){
Text("YO")
}

