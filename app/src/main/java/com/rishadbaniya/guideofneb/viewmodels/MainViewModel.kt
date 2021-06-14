package com.rishadbaniya.guideofneb.viewmodels

import androidx.compose.material.DrawerValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.*
import io.reactivex.rxjava3.subjects.PublishSubject
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch

class MainViewModel constructor(
//    private val appDataStore: AppDataStore
) : ViewModel(){

    val openDrawer : () -> Unit = {
        viewModelScope.launch {
            drawerActionsSubject.onNext(DrawerValue.Open)
        }
    }

    val drawerActionsSubject : PublishSubject<DrawerValue> = PublishSubject.create()



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
