package com.rishadbaniya.guideofneb.ui.screens.tools.toolDetail

import android.content.Context
import android.icu.number.UnlocalizedNumberFormatter
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.VelocityTracker
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavHostController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.rishadbaniya.guideofneb.ui.DOWNLOAD
import com.rishadbaniya.guideofneb.ui.FLAG
import com.rishadbaniya.guideofneb.ui.components.BACK_BUTTON
import com.rishadbaniya.guideofneb.ui.components.DOWNLOAD_BUTTON
import com.rishadbaniya.guideofneb.ui.components.MORE_MENU_BUTTON
import com.rishadbaniya.guideofneb.ui.theme.SOURCE_SAN_PRO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Math.abs
import androidx.compose.ui.unit.dp as dp


@ExperimentalMaterialApi
@Composable
fun RenderedSolution(
    navController : NavHostController
){
    val scope = rememberCoroutineScope()
    val bottomDrawerState = rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed)
    val onBackClick : () -> Unit = {
        scope.launch {
            navController.popBackStack()
        }
    }

    val onMoreClick : () -> Unit = {
        scope.launch {
           bottomDrawerState.open()
        }
    }

    val onDownloadClick : () -> Unit = {

    }
        BOTTOM_DRAWER(bottomDrawerState = bottomDrawerState) {
            Column {
                APP_BAR(onBackClick = onBackClick, onMoreClick = onMoreClick, onDownloadClick = onDownloadClick)
                QUESTION_ANSWER(modifier = Modifier.weight(1f))
                BANNER_AD()
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun BOTTOM_DRAWER(
    bottomDrawerState : BottomDrawerState,
    content : @Composable () -> Unit
){
    val scope = rememberCoroutineScope()
    val closeDrawer : () -> Unit = {
        scope.launch { bottomDrawerState.close() }
    }
    BottomDrawer(
        drawerContent = {
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)){
                Column() {
                    BOTTOM_DRAWER_ITEM(icon = FLAG, label = "Report",onClick = closeDrawer )
                    BOTTOM_DRAWER_ITEM(icon = DOWNLOAD, label = "Download for offline use" , onClick = closeDrawer)
                }

            }
        },
        drawerState = bottomDrawerState,
        gesturesEnabled = bottomDrawerState.isOpen,
        content = content
    )
}

@Composable
private fun BOTTOM_DRAWER_ITEM(
    icon : Int,
    label : String,
    onClick: () -> Unit
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable { }){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ){
            Icon(
                painter = painterResource(DOWNLOAD),
                contentDescription = null,
                tint = Color.Black
            )
            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = "Download for offline use",
                color = Color.Black,
                fontFamily = SOURCE_SAN_PRO
            )
        }
    }
}

@Composable
private fun QUESTION_ANSWER(
    modifier : Modifier
){
    Column(modifier = modifier.verticalScroll(rememberScrollState())){
        QUESTION()
        SOLUTION()
    }
}

@Composable
private fun BANNER_AD() {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White)
        ,
        factory = {
                context -> AdView(context).apply {
            adSize = AdSize.BANNER
            adUnitId = "ca-app-pub-3940256099942544/6300978111";
            val adRequest = AdRequest.Builder().build()
            loadAd(adRequest)
        }
        }
    )
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
                .fillMaxWidth(),
            factory = {
                    context -> QuestionAndAnswerWebView(context).apply {
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
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
    ){
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            factory = {
                    context -> QuestionAndAnswerWebView(context).apply {
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



class QuestionAndAnswerWebView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : WebView(context, attrs) {
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // When the user's finger touches the webview and starts moving
        if(event?.action == MotionEvent.ACTION_MOVE){
            // get the velocity tracker object
            val mVelocityTracker = VelocityTracker.obtain();

            // connect the velocity tracker object with the event that we are emitting while we are touching the webview
            mVelocityTracker.addMovement(event)

            // compute the velocity in terms of pixels per 1000 millisecond(i.e 1 second)
            mVelocityTracker.computeCurrentVelocity(1000);

            // compute the Absolute Velocity in X axis
            val xVelocityABS = abs(mVelocityTracker.getXVelocity(event?.getPointerId((event?.actionIndex))));

            // compute the Absolute Velocity in Y axis
            val yVelocityABS = abs(mVelocityTracker.getYVelocity(event?.getPointerId((event?.actionIndex))));

            // If the velocity of x axis is greater than y axis then we'll consider that it's a horizontal scroll and tell the parent layout
            // "Hey parent bro! im scrolling horizontally, this has nothing to do with ur scrollview so stop capturing my event and stay the f*** where u are "
            if(xVelocityABS > yVelocityABS){
                //  So, we'll disallow the parent to listen to any touch events until i have moved my fingers off the screen
                parent.requestDisallowInterceptTouchEvent(true)
            }
        } else if (event?.action == MotionEvent.ACTION_CANCEL || event?.action == MotionEvent.ACTION_UP){
            // If the touch event has been cancelled or the finger is off the screen then reset it (i.e let the parent capture the touch events on webview as well)
            parent.requestDisallowInterceptTouchEvent(false)
        }
        return super.onTouchEvent(event)
    }
}
