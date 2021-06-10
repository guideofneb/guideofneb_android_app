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
import com.rishadbaniya.guideofneb.ui.components.APP_BAR as AppBar

@Composable
fun GuideofNEBApp(){
    val navController = rememberNavController();
    Column {
        AppBar()
        Body(modifier = Modifier.weight(1f), navController = navController)
        BottomNavigationBar(
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
        composable("home"){
        }
        composable("notes"){
        }
        composable("solutions"){
        }
        composable("tools"){
        }
        composable("news"){
        }
        composable("library"){
        }
    }
}



