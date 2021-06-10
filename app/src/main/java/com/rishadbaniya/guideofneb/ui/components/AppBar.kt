package com.rishadbaniya.guideofneb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.rishadbaniya.guideofneb.ui.APP_LOGO
import com.rishadbaniya.guideofneb.ui.theme.SOURCE_SAN_PRO

private val APP_BAR_HEIGHT = 48.dp



@Composable
fun APP_BAR(){
    Row (
        modifier = Modifier
            .height(APP_BAR_HEIGHT)
            .padding(start = 12.dp,end = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
       LOGO_AND_TEXT()
    }
}

@Composable
private fun LOGO_AND_TEXT (){
    Row(
        modifier = Modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = APP_LOGO),
            contentDescription = null,
            modifier = Modifier.size(36.dp)
        )
        Text(
            modifier = Modifier.padding(start = 2.dp),
            text = "guideofneb",
            fontSize = 4.4.em,
            fontWeight = FontWeight.Bold,
            fontFamily = SOURCE_SAN_PRO
        )
    }

}
