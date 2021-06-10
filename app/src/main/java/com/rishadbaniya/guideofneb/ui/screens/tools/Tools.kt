package com.rishadbaniya.guideofneb.ui.screens.tools

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.rishadbaniya.guideofneb.ui.ADD
import com.rishadbaniya.guideofneb.ui.KEY
import com.rishadbaniya.guideofneb.ui.components.HoriziontalDivider
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.ui.theme.SOURCE_SAN_PRO

private val KEYS_BAR_HEIGHT = 48.dp;

@Composable
fun TOOLS(){
   Column() {
      TOOLS_KEYS_BAR()

      Column(
      ) {
      }
   }

}

@Composable
private fun TOOLS_KEYS_BAR(){
   Column {
      Row(
         modifier = Modifier
            .fillMaxWidth()
            .height(KEYS_BAR_HEIGHT)
            .padding(start = 12.dp),
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.SpaceBetween
      ){
         NO_OF_KEYS(
            noOfKeys = 10
         )
         ADD_KEYS_BUTTON()
      }
      HoriziontalDivider()
   }

}

@Composable
private fun ADD_KEYS_BUTTON(){
   Icon(
      painter = painterResource(ADD),
      contentDescription = null,
      modifier = Modifier
         .size(48.dp)
         .clickable(
            onClick = {

            },
            indication = rememberRipple(bounded = false, radius = 24.dp),
            interactionSource = MutableInteractionSource()
         )
         .padding(12.dp)
   )
}

@Composable
private fun NO_OF_KEYS(
   noOfKeys : Int
){
   Row (
      modifier = Modifier
         .padding(horizontal = 2.dp)
         .clip(RoundedCornerShape(10)),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center,
   ){
      Icon(
         painter = painterResource(id = KEY),
         contentDescription = null,
         tint = GuideOfNEBTheme.colors.onBackground
      )
      Text(
         text = " : $noOfKeys",
         fontFamily = SOURCE_SAN_PRO,
         fontWeight = FontWeight.Bold,
         fontSize = (3.8).em,
         color = GuideOfNEBTheme.colors.onBackground
      )
   }
}


@Composable
fun ToosList(){

}

@Composable
fun Tool(){

}

