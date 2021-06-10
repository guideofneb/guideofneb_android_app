package com.rishadbaniya.guideofneb.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rishadbaniya.guideofneb.ui.components.BottomNavigationItem
import com.rishadbaniya.guideofneb.ui.components.BottomNavigationBar
import com.rishadbaniya.guideofneb.R;

val BOTTOM_NAVIGATION_ITEMS = listOf<BottomNavigationItem>(
    BottomNavigationItem(label = LABEL_HOME , icons = listOf(HOME_LINE, HOME_FILL), route = "home"),
    BottomNavigationItem(label = LABEL_NOTES , icons = listOf(NOTES_LINE, NOTES_FILL), route = "notes"),
    BottomNavigationItem(label = LABEL_SOLUTIONS, icons = listOf(SOLUTIONS_LINE, SOLUTIONS_FILL), route = "solutions"),
    BottomNavigationItem(label = LABEL_TOOLS, icons = listOf(TOOLS_LINE, TOOLS_FILL), route = "tools"),
    BottomNavigationItem(label = LABEL_NEWS, icons = listOf(NEWS_LINE, NEWS_FILL), route = "news"),
    BottomNavigationItem(label = LABEL_LIBRARY, icons = listOf(STACK_LINE, STACK_FILL), route = "library"),
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

