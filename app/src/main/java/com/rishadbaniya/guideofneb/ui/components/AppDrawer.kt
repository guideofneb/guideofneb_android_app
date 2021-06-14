package com.rishadbaniya.guideofneb.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.viewmodels.LocalMainViewModel
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(
    navController: NavHostController,
    content : @Composable () -> Unit
){
    val scope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(DrawerValue.Closed);
    LocalMainViewModel.current.drawerActionsSubject.subscribe {
        if (it != null) {
            if (it == DrawerValue.Open){
               scope.launch {
                   drawerState.open()
               }
            }
        }
    }
    BoxWithConstraints() {
        Box(modifier = Modifier.fillMaxSize()){
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                ModalDrawer(
                    drawerContent = {
                        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        }
                    },
                    drawerState = drawerState,
                    drawerBackgroundColor = GuideOfNEBTheme.colors.background,
                    gesturesEnabled = drawerState.isOpen
                ) {
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                        content()
                    }
                }

            }
        }
    }
}



