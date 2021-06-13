package com.rishadbaniya.guideofneb.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.rishadbaniya.guideofneb.ui.components.APP_BAR

@Composable
fun SETTING(
    navController: NavHostController
){
    Column(){
        SETTING_APP_BAR(
            navController = navController
        )
        SETTING_BODY(
            modifier = Modifier.weight(1f)
        )
        SETTING_BANNER_AD()
    }
}


@Composable
private fun SETTING_APP_BAR(
    navController: NavHostController
){
    APP_BAR(
        showDrawer = false,
        showLogo = false ,
        navController = navController
   )
}



@Composable
private fun SETTING_BODY(
    modifier: Modifier
){
    Column(modifier) {
        Text("YOYO")
    }
}

@Composable
private fun SETTING_BANNER_AD(){

}


