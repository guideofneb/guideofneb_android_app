package com.rishadbaniya.guideofneb.viewmodels

import androidx.lifecycle.ViewModel
import com.rishadbaniya.guideofneb.data.AppDataStore
import com.rishadbaniya.guideofneb.model.Theme
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val appDataStore: AppDataStore
) : ViewModel(){
    val getTheme : Flow<Theme> get() = appDataStore.getTheme

    val setTheme : (Theme) -> Unit get() = appDataStore.setTheme
}