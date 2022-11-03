package com.example.jabda.network.retrofit

import android.content.Context
import android.content.SharedPreferences

class SharedPreFerences(context : Context) {
    private val prefsFile = "a"
    private val prefsFilename = "name"
    private val prefs: SharedPreferences = context.getSharedPreferences(prefsFile,0)

    var data : String?
        get() = prefs.getString(prefsFilename,"")
        set(value) = prefs.edit().putString(prefsFilename,value).apply()
}