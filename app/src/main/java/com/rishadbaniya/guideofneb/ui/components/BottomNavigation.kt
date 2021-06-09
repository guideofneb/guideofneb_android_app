package com.rishadbaniya.guideofneb.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class BottomNavigationItem(val label : Int, val icon : Int, val route : Int);

@Composable
fun BottomNavigation(
    items : List<BottomNavigationItem>,
    navController : NavHostController
){
    Row(modifier = Modifier
        .height(48.dp)
        .fillMaxWidth()){
        items.forEach{ item ->
            BottomNavigationItem(
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate("${item.route}")},
                icon = item.icon,
                label = item.label
            )
        }
    }

}

@Composable
fun BottomNavigationItem(
    modifier : Modifier,
    onClick : () -> Unit,
    icon : Int,
    label : Int,
){
    Column(modifier = modifier){
        BottomNavigationIcon(icon = icon)
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