package com.rishadbaniya.guideofneb.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rishadbaniya.guideofneb.ui.components.BottomNavigationItem
import com.rishadbaniya.guideofneb.ui.components.BottomNavigationOrBannerAd



@Composable
fun GuideofNEBApp(){
    val navController = rememberNavController();
    Column {
        AppBar()
        NavHost(navController = navController, startDestination = "home", modifier = Modifier.weight(1f)){

        }
        BottomNavigationOrBannerAd(
            items = listOf(BottomNavigationItem(10,10,"")),
            navController = navController,
            showBannerAd = false
        )
  }
}

@Composable
fun Body(
   modifier : Modifier
){


}


@Composable
fun AppBar(){

}

