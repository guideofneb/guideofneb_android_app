package com.rishadbaniya.guideofneb.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.rishadbaniya.guideofneb.model.Theme
import com.rishadbaniya.guideofneb.repositories.AppDataStoreInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


class AppDataStore @Inject constructor(val appDataStore : DataStore<Preferences> ) : AppDataStoreInterface{
    object Keys {
        val THEME = stringPreferencesKey("THEME");
    }

    override val getTheme: Flow<Theme> = appDataStore.data.map {
        when(it[Keys.THEME]){
            "DARK" -> Theme.DARK
            "LIGHT" -> Theme.LIGHT
            "SYSTEM" -> Theme.SYSTEM
            else ->{
                setTheme(Theme.SYSTEM)
                Theme.SYSTEM
            }
        }
    }

    override val setTheme: (Theme) -> Unit = { theme : Theme ->
        CoroutineScope(Dispatchers.IO).launch {
            appDataStore.edit {
                it[Keys.THEME] = theme.toString()
            }
        }
    }

}