package com.rishadbaniya.guideofneb.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBColors
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.ui.theme.SOURCE_SAN_PRO

val BOTTOM_NAVIGATION_BAR_HEIGHT = 48.dp
val BOTTOM_NAVIGATION_LABEL_FONT_SIZE = (2.3).em ;

class BottomNavigationItem(
    val label : String,
    val icons : List<Int>,
    val route : String
)

@Composable
fun BottomNavigationBar(
    items : List<BottomNavigationItem>,
    navController : NavHostController,
    showBannerAd : Boolean
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(BOTTOM_NAVIGATION_BAR_HEIGHT)
        .background(GuideOfNEBTheme.colors.background)
    ){
        if(showBannerAd){
            BannerAd()
        }else{
            BottomNavigation(items = items , navController = navController)
        }
    }
}

@Composable
private fun BannerAd(){

}

@Composable
private fun BottomNavigation(
    items: List<BottomNavigationItem>,
    navController: NavHostController
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clipToBounds(),
        verticalAlignment = Alignment.CenterVertically
    ){
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
private fun BottomNavigationItem(
    modifier : Modifier,
    navController: NavHostController,
    icons : List<Int>,
    label : String,
    route : String
){
    val navBackStackEntry by navController.currentBackStackEntryAsState();
    val currentDestinaiton = navBackStackEntry?.destination?.route;
    Column(
        modifier = modifier
            .fillMaxHeight()
            .clickable(
                indication = rememberRipple(bounded = false),
                interactionSource = remember { MutableInteractionSource() },
                onClick = {
                    navController.navigate(route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        BottomNavigationIcon(if(currentDestinaiton == route) icons[1] else icons[0])
        BottomNavigationLabel(label)
    }
}


@Composable
private fun BottomNavigationIcon(
    icon : Int,
){
    Icon(
      painter = painterResource(id = icon),
      contentDescription = null,
      tint = GuideOfNEBTheme.colors.onBackground
    )
}

@Composable
private fun BottomNavigationLabel(
    label : String
) = Text(
    modifier = Modifier.padding(top = 1.dp),
    text = label,
    color = GuideOfNEBTheme.colors.onBackground,
    fontSize = BOTTOM_NAVIGATION_LABEL_FONT_SIZE,
    fontFamily = SOURCE_SAN_PRO,
    fontWeight = FontWeight.Normal
)
