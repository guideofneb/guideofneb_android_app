package com.rishadbaniya.guideofneb.repositories

import com.rishadbaniya.guideofneb.model.Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface AppDataStoreInterface{
    val getTheme : Flow<Theme>;

    val setTheme : (Theme) -> Unit
}