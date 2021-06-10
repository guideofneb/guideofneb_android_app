package com.rishadbaniya.guideofneb.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

val BOTTOM_NAVIGATION_BAR_HEIGHT = 48.dp

class BottomNavigationItem(
    val label : Int,
    val icons : List<Int>,
    val route : String
)

@Composable
fun BottomNavigationBar(
    items : List<BottomNavigationItem>,
    navController : NavHostController,
    showBannerAd : Boolean
){
    Box(modifier = Modifier.fillMaxWidth().height(BOTTOM_NAVIGATION_BAR_HEIGHT)){
        if(showBannerAd){
            BannerAd()
        }else{
            BottomNavigation(items = items , navController = navController)
        }
    }
}

@Composable
fun BannerAd(){

}

@Composable
fun BottomNavigation(
    items: List<BottomNavigationItem>,
    navController: NavHostController
){
    Row(modifier = Modifier
        .fillMaxWidth()){
        items.forEach{ item ->
            BottomNavigationItem(
                modifier = Modifier.weight(1f),
                navController = navController,
                icons = item.icons,
                label = item.label,
                route = item.route
            )
        }
    }
}

@Composable
fun BottomNavigationItem(
    modifier : Modifier,
    navController: NavHostController,
    icons : List<Int>,
    label : Int,
    route : String
){
    Column(
        modifier = modifier.clickable(
            onClick = {
               navController.navigate(route)
            }
        )
    ){
        BottomNavigationIcon(icon = icons[0])
        BottomNavigationLabel(label = label)
    }
}


// Icon representing the bottom navigation
@Composable
fun BottomNavigationIcon(
    icon : Int
){
    Icon(
      painter = painterResource(id = icon),
      contentDescription = null
    )
}

// Text label that's below an icon in bottom navigation
@Composable
fun BottomNavigationLabel(
    label : Int
){
    Icon(
        painter = painterResource(id = label),
        contentDescription = null
    )
}