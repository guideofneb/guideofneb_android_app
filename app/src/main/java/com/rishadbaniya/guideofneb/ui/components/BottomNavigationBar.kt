package com.rishadbaniya.guideofneb.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
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
import com.rishadbaniya.guideofneb.ui.*
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBColors
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.ui.theme.SOURCE_SAN_PRO

private val BOTTOM_NAVIGATION_BAR_HEIGHT = 48.dp

private val BOTTOM_NAVIGATION_LABEL_FONT_SIZE = (2.2).em ;

private val BOTTOM_NAVIGATION_ITEMS = listOf<BottomNavigationItem>(
    BottomNavigationItem(label = "Home" , icons = listOf(HOME_LINE, HOME_FILL), route = "home"),
    BottomNavigationItem(label = "Notes" , icons = listOf(NOTES_LINE, NOTES_FILL), route = "notes"),
    BottomNavigationItem(label = "Solutions" , icons = listOf(SOLUTIONS_LINE, SOLUTIONS_FILL), route = "solutions"),
    BottomNavigationItem(label = "Tools", icons = listOf(TOOLS_LINE, TOOLS_FILL), route = "tools"),
    BottomNavigationItem(label = "News" , icons = listOf(NEWS_LINE, NEWS_FILL), route = "news"),
    BottomNavigationItem(label = "Library", icons = listOf(STACK_LINE, STACK_FILL), route = "library"),
)

class BottomNavigationItem(
    val label : String,
    val icons : List<Int>,
    val route : String
)

@Composable
fun BottomNavigationBar(
    navController : NavHostController,
    showBannerAd : Boolean
){
    Column {
        HoriziontalDivider()
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(BOTTOM_NAVIGATION_BAR_HEIGHT)
            .background(GuideOfNEBTheme.colors.background)
        ){
            if(showBannerAd){
                BannerAd()
            }else{
                BottomNavigation(navController = navController)
            }
        }
    }

}

@Composable
private fun HoriziontalDivider(){
    Divider(thickness = (1.2).dp,color = GuideOfNEBTheme.colors.horizontalDividier)
}

@Composable
private fun BannerAd(){

}

@Composable
private fun BottomNavigation(
    navController: NavHostController
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clipToBounds(),
        verticalAlignment = Alignment.CenterVertically
    ){
        BOTTOM_NAVIGATION_ITEMS.forEach{ item ->
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
        modifier = Modifier.size(23.dp),
      painter = painterResource(id = icon),
      contentDescription = null,
      tint = GuideOfNEBTheme.colors.onBackground
    )
}

@Composable
private fun BottomNavigationLabel(
    label : String
) = Text(
    modifier = Modifier.padding(top = (2).dp),
    text = label,
    color = GuideOfNEBTheme.colors.onBackground,
    fontSize = BOTTOM_NAVIGATION_LABEL_FONT_SIZE,
    fontFamily = SOURCE_SAN_PRO,
    fontWeight = FontWeight.Normal
)
