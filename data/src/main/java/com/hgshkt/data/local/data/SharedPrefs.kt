package com.hgshkt.data.local.data

interface SharedPrefs {
    fun getCurrentUserId(): String

    fun putCurrentUserId(id: String)
}