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
import com.rishadbaniya.guideofneb.ui.components.AppBar

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



