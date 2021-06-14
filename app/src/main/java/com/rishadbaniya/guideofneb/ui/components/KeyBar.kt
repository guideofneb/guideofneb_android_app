package com.rishadbaniya.guideofneb.ui.components

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.rishadbaniya.guideofneb.ui.ADD
import com.rishadbaniya.guideofneb.ui.KEY
import com.rishadbaniya.guideofneb.ui.theme.GuideOfNEBTheme
import com.rishadbaniya.guideofneb.ui.theme.SOURCE_SAN_PRO
import com.rishadbaniya.guideofneb.viewmodels.LocalMainViewModel
import com.rishadbaniya.guideofneb.viewmodels.MainViewModel


private val KEYS_BAR_HEIGHT = 48.dp;
enum class KEY_STATUS {
    AVAILAIBLE,
    TO_SPEND
}

@Composable
fun KEY_BAR(){
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
    val openAddMoreKeysDialog = LocalMainViewModel.current.openAddMoreKeysDialog;
    Icon(
        painter = painterResource(ADD),
        tint = GuideOfNEBTheme.colors.onBackground,
        contentDescription = null,
        modifier = Modifier
            .size(48.dp)
            .clickable(
                onClick = openAddMoreKeysDialog,
                indication = rememberRipple(bounded = false, radius = 24.dp),
                interactionSource = MutableInteractionSource()
            )
            .padding(12.dp)
    )
}

@Composable
fun NO_OF_KEYS(
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
            .padding(horizontal = 8.dp, vertical = 4.dp),
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
            fontSize = (3.6).em,
            color = GuideOfNEBTheme.colors.onKey
        )
    }
}
