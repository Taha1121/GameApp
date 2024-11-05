package com.example.gameapp

/*
import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extension property to initialize DataStore on Context
private val Context.dataStore by preferencesDataStore(name = "app_preferences")

// Data class to represent AppPreferences
data class AppPreferences(
    val userName: String = "",
    val highScore: Int = 0,
    val darkMode: Boolean = false
)

class AppStorage(private val context: Context) {

    companion object {
        // Define preference keys
        private object PreferencesKeys {
            val USERNAME = stringPreferencesKey("user_name")
            val HIGHSCORE = intPreferencesKey("high_score")
            val DARK_MODE = booleanPreferencesKey("dark_mode")
        }
    }

    // Flow to observe changes in app preferences
    val appPreferenceFlow: Flow<AppPreferences> = context.dataStore.data
        .map { preferences ->
            val userName = preferences[PreferencesKeys.USERNAME] ?: ""
            val highScore = preferences[PreferencesKeys.HIGHSCORE] ?: 0
            val darkMode = preferences[PreferencesKeys.DARK_MODE] ?: false
            AppPreferences(userName, highScore, darkMode)
        }

    // Save username in DataStore
    suspend fun saveUsername(username: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.USERNAME] = username
        }
    }

    // Save high score in DataStore
    suspend fun saveHighscore(highScore: Int) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.HIGHSCORE] = highScore
        }
    }

    // Save dark mode preference in DataStore
    suspend fun saveDarkmode(darkMode: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.DARK_MODE] = darkMode
        }
    }
}
*/