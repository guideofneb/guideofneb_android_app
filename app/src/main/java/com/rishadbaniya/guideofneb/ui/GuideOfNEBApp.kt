package com.rishadbaniya.guideofneb.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rishadbaniya.guideofneb.BaseApplication
import com.rishadbaniya.guideofneb.MainActivity
import com.rishadbaniya.guideofneb.ui.components.APP_DRAWER
import com.rishadbaniya.guideofneb.ui.components.BottomNavigationBar
import com.rishadbaniya.guideofneb.ui.screens.SETTING
import com.rishadbaniya.guideofneb.ui.screens.tools.TOOLS
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.viewmodels.LocalMainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.rishadbaniya.guideofneb.ui.components.APP_BAR as AppBar

object ROUTES {
    const val HOME = "home"
    const val NOTES = "notes"
    const val SOLUTIONS = "solutions"
    const val TOOLS = "tools"
    const val NEWS = "news"
    const val LIBRARY = "library"
    const val SETTINGS = "settings"
}

private val ROUTES_TO_SHOW_BOTTOM_NAV = arrayOf(
    ROUTES.HOME,
    ROUTES.NOTES,
    ROUTES.TOOLS,
    ROUTES.SOLUTIONS,
    ROUTES.TOOLS,
    ROUTES.NEWS,
    ROUTES.LIBRARY
);


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun GuideofNEBApp(
    navController: NavHostController
){
    APP_DRAWER(navController = navController) {
        Column {
            Body(modifier = Modifier.weight(1f), navController = navController)
            BottomNavigationBar(
                navController = navController,
                routesToShowBottomNav = ROUTES_TO_SHOW_BOTTOM_NAV
            )
        }
    }
}

@Composable
fun Body(
    modifier : Modifier,
   navController : NavHostController
){
    NavHost(navController = navController, startDestination = "home", modifier = modifier){
        composable("home"){
        }
        composable("notes"){
        }
        composable("solutions"){
        }
        composable("tools"){
           Column{
               AppBar(
                   showLogo = true,
                   navController = navController,
                   showDrawer = true
               )
               TOOLS(modifier = Modifier.weight(1f))
           }
        }

        composable("news"){
        }
        composable(ROUTES.LIBRARY){

        }
        composable(ROUTES.SETTINGS){
            SETTING(navController = navController)
        }
    }
}




