package com.rishadbaniya.guideofneb.ui.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.viewmodels.LocalMainViewModel
import kotlinx.coroutines.launch

@Composable
fun APP_DRAWER(
    navController: NavHostController,
    content : @Composable () -> Unit
){
    val scope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(DrawerValue.Closed);
    LocalMainViewModel.current.drawerActions.observeForever(Observer {
        if(it != null){
            if(it == DrawerValue.Open){
                scope.launch {
                    drawerState.open()
                }
            }
        }
    })

    BoxWithConstraints() {
        ModalDrawer(
            drawerContent = {
            },
            drawerState = drawerState,
            drawerBackgroundColor = GuideOfNEBTheme.colors.background,
            gesturesEnabled = drawerState.isOpen

        ){content()}
    }
}
