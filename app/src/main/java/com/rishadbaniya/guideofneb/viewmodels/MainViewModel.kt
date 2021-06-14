package com.rishadbaniya.guideofneb.viewmodels

import androidx.compose.material.DrawerValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch

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



    val addMoreKeysDialogLiveData : MutableLiveData<Boolean> = MutableLiveData(false);
    val closeAddMoreKeysDialog : () -> Unit = {
        viewModelScope.launch {
            addMoreKeysDialogLiveData.value = false
        }
    }
    val openAddMoreKeysDialog : () -> Unit = {
        viewModelScope.launch {
            addMoreKeysDialogLiveData.value = true
        }
    }

}

val LocalMainViewModel = staticCompositionLocalOf<MainViewModel>{error("MainViewModel was not provided")}
