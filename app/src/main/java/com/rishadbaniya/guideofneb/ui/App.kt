package com.rishadbaniya.guideofneb.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rishadbaniya.guideofneb.ui.components.AppDrawer
import com.rishadbaniya.guideofneb.ui.components.BottomNavigationBar
import com.rishadbaniya.guideofneb.ui.screens.SETTING
import com.rishadbaniya.guideofneb.ui.screens.tools.TOOLS
import com.rishadbaniya.guideofneb.ui.components.APP_BAR as AppBar
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.Observer
import com.rishadbaniya.guideofneb.R;
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.viewmodels.LocalMainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

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


@Composable
fun GuideofNEBApp(
    navController: NavHostController
){
     AppDrawer(navController = navController) {
             Column() {
                 Box(modifier = Modifier
                     .weight(1f)
                     .fillMaxSize()) {
                     Body( navController = navController)
                     FloatingActionButton(
                         modifier = Modifier
                             .align(Alignment.BottomEnd)
                             .offset(-12.dp, -12.dp),
                         onClick = { /*TODO*/ },
                         backgroundColor = GuideOfNEBTheme.colors.keyToSpend
                     ){
                         Icon(
                             painterResource(id = R.drawable.ic_baseline_search_24),
                             contentDescription = null,
                             tint = Color.White
                         )
                     }
                 }
                 BottomNavigationBar(
                     navController = navController,
                     routesToShowBottomNav = ROUTES_TO_SHOW_BOTTOM_NAV
                 )
                 AddMoreKeysDialog()
             }

          }
        }
@Composable
fun AddMoreKeysDialog(){
    val isDialogOpen by LocalMainViewModel.current.addMoreKeysDialogLiveData.observeAsState();
    val closeDialog = LocalMainViewModel.current.closeAddMoreKeysDialog;
    if(isDialogOpen!!){
        Dialog(
            onDismissRequest = closeDialog
        ){
            Surface(color = GuideOfNEBTheme.colors.background) {
                Text("YOYOYOYOY")
            }
        }
    }
}

@Composable
fun Body(
   navController : NavHostController
){
    NavHost(navController = navController, startDestination = "home", modifier = Modifier.fillMaxSize()){
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
