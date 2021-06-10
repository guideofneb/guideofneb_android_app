package com.rishadbaniya.guideofneb.ui.screens.tools

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
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

private enum class KEY_STATUS {
   AVAILAIBLE,
   TO_SPEND
}

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
            noOfKeys = 10,
            keyStatus = KEY_STATUS.AVAILAIBLE
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
      tint = GuideOfNEBTheme.colors.onBackground,
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
   noOfKeys : Int,
   keyStatus: KEY_STATUS
){
   val keyBackground = if(keyStatus == KEY_STATUS.AVAILAIBLE){
      GuideOfNEBTheme.colors.keyAvailaible
   }else{
      GuideOfNEBTheme.colors.keyToSpend
   }

   Row (
      modifier = Modifier
         .clip(RoundedCornerShape(20))
         .background(keyBackground)
         .padding(horizontal = 6.dp,vertical = 4.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center,
   ){
      Icon(
         painter = painterResource(id = KEY),
         contentDescription = null,
         tint = GuideOfNEBTheme.colors.onKey
      )
      Text(
         text = " : $noOfKeys",
         fontFamily = SOURCE_SAN_PRO,
         fontWeight = FontWeight.Bold,
         fontSize = (3.8).em,
         color = GuideOfNEBTheme.colors.onKey
      )
   }
}


@Composable
fun ToosList(){

}

@Composable
fun Tool(){

}

