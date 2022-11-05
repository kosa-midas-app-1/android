package com.example.jabda

import android.app.Application
import com.example.jabda.network.retrofit.SharedPreFerences

class JabdaApp: Application() {
    companion object {
        lateinit var prefs: SharedPreFerences
    }

    override fun onCreate() {
        super.onCreate()
        prefs = SharedPreFerences(applicationContext)
    }
}