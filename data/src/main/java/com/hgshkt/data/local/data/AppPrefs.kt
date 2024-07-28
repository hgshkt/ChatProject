package com.hgshkt.data.local.data

import android.content.SharedPreferences

class AppPrefs(
    private val prefs: SharedPreferences
):SharedPrefs {
    private val currentUserIdKey = "CurrentUserIdKey"
    override fun getCurrentUserId(): String {
        return prefs.getString(currentUserIdKey, "")!!
    }

    override fun putCurrentUserId(id: String) {
        prefs.edit().putString(currentUserIdKey, id).apply()
    }
}