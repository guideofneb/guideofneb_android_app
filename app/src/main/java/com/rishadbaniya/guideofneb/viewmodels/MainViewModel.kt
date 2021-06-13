package com.rishadbaniya.guideofneb.viewmodels

import android.util.Log
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.*
import com.rishadbaniya.guideofneb.data.AppDataStore
import com.rishadbaniya.guideofneb.model.Theme
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.produceIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel constructor(
//    private val appDataStore: AppDataStore
) : ViewModel(){

    val openDrawer : () -> Unit = {
        viewModelScope.launch {
            drawerChannel.send(DrawerValue.Open)
        }
    }

    private val drawerChannel : BroadcastChannel<DrawerValue> = BroadcastChannel<DrawerValue>(1);
    val drawerActions : LiveData<DrawerValue> = drawerChannel.asFlow().asLiveData()
}

val LocalMainViewModel = staticCompositionLocalOf<MainViewModel>{error("MainViewModel was not provided")}
