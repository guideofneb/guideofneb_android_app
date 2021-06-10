package com.rishadbaniya.guideofneb.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.rishadbaniya.guideofneb.ui.APP_LOGO
import com.rishadbaniya.guideofneb.ui.HAMBURGER_MENU
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.ui.theme.SOURCE_SAN_PRO

private val APP_BAR_HEIGHT = 48.dp



@Composable
fun APP_BAR(){
    Column {
        Row (
            modifier = Modifier
                .height(APP_BAR_HEIGHT)
                .padding(start = 12.dp)
                .fillMaxWidth()
                .clipToBounds(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            LOGO_AND_TEXT()
            HAMBURGER_DRAWER_BUTTON(
                onClick = {

                }
            )
        }
        HoriziontalDivider()
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
            modifier = Modifier.size(34.dp)
        )
        Text(
            modifier = Modifier.padding(start = 2.dp),
            text = "guideofneb",
            fontSize = 4.4.em,
            fontWeight = FontWeight.Bold,
            fontFamily = SOURCE_SAN_PRO,
            color = GuideOfNEBTheme.colors.onBackground

        )
    }
}

@Composable
private fun HAMBURGER_DRAWER_BUTTON(
    onClick : () -> Unit
){
    Icon(
        painter = painterResource(id = HAMBURGER_MENU ),
        contentDescription = null,
        tint = GuideOfNEBTheme.colors.onBackground,
        modifier = Modifier
            .size(48.dp)
            .clickable(
                onClick = onClick,
                indication = rememberRipple(bounded = false, radius = 24.dp),
                interactionSource = MutableInteractionSource()
            )
            .padding(12.dp)
    )
}

@Composable
private fun MORE_MENU_BUTTON(
){

}