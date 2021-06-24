package com.rishadbaniya.guideofneb.ui.screens.tools.toolDetail

import android.content.Context
import android.icu.number.UnlocalizedNumberFormatter
import android.util.AttributeSet
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavHostController
import com.rishadbaniya.guideofneb.ui.components.BACK_BUTTON
import com.rishadbaniya.guideofneb.ui.components.DOWNLOAD_BUTTON
import com.rishadbaniya.guideofneb.ui.components.MORE_MENU_BUTTON
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
@Composable
fun RenderedSolution(
    navController : NavHostController
){
    val scope = rememberCoroutineScope()
    val bottomDrawerState = rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed)
    val onBackClick : () -> Unit = { navController.popBackStack() }
    val onMoreClick : () -> Unit = {
        scope.launch {
            bottomDrawerState.open()
        }
    }
    val onDownloadClick : () -> Unit = {}
        BottomDrawer(
            gesturesEnabled = false,
            drawerContent = {
                   Text("YOYOYO")
            },
            drawerState = bottomDrawerState
        ) {
            Column() {
                APP_BAR(
                    onBackClick = onBackClick,
                    onMoreClick = onMoreClick,
                    onDownloadClick = onDownloadClick
                )
                Column() {
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(12.dp))
                    QUESTION()
                }
            }
        }
}

@Composable
private fun APP_BAR(
    onBackClick : () -> Unit,
    onMoreClick : () -> Unit,
    onDownloadClick : () -> Unit,
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ){
        BACK_BUTTON (onClick = onBackClick)
        Row(){
            DOWNLOAD_BUTTON (onClick = onDownloadClick)
            MORE_MENU_BUTTON(onClick = onMoreClick)
        }
    }
}

@Composable
private fun QUESTION(){
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))

    ){
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            factory = {
                    context -> SolutionWebView(context).apply {
                webViewClient = WebViewClient()
                settings.apply {
                    javaScriptEnabled = true;
                }
                loadUrl("http://192.168.1.71:3000")
            }
            }
        )
    }

}

@Composable
private fun SOLUTION(){
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red),
        factory = {
            context -> SolutionWebView(context).apply {
                webViewClient = WebViewClient()
                settings.apply {
                    javaScriptEnabled = true;
                }
                loadUrl("https://www.youtube.com")
            }
        }
    )
}



class QuestionWebView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : WebView(context, attrs) {


}

class SolutionWebView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : WebView(context, attrs) {

}