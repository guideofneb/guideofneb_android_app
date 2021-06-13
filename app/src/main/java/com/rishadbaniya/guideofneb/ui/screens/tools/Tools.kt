package com.rishadbaniya.guideofneb.ui.screens.tools

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rishadbaniya.guideofneb.ui.components.KEY_BAR
import com.rishadbaniya.guideofneb.ui.components.KEY_STATUS
import com.rishadbaniya.guideofneb.ui.components.NO_OF_KEYS
import com.rishadbaniya.guideofneb.ui.theme.SOURCE_SAN_PRO

@Composable
fun TOOLS(
   modifier : Modifier
){
   Column (modifier){
      KEY_BAR()
      Column (
         Modifier
            .verticalScroll(rememberScrollState())
            .padding(12.dp)
      ){
         TOOL()
      }
   }

}

@Composable
fun TOOLS_LIST(){

}

@Composable
fun TOOL(){
   Card(
      modifier = Modifier
         .padding(bottom = 12.dp)
         .fillMaxWidth(),
      backgroundColor = Color.White,
      elevation = 2.dp,
      shape = RoundedCornerShape(15)

   ) {
      Box(
         modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
      ){
         TOOL_TITLE_AND_KEY()
      }
   }
}

@Composable
fun TOOL_TITLE_AND_KEY(){
   Row(
      modifier = Modifier
         .fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
   ){
      Text(
         "Gauss Siedel Solver",
         fontFamily = SOURCE_SAN_PRO,
         fontWeight = FontWeight.SemiBold,
      )
      NO_OF_KEYS(noOfKeys = 5, keyStatus = KEY_STATUS.TO_SPEND)
   }
}
