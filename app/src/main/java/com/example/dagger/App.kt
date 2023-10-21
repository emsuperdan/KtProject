package com.example.dagger

import android.app.Application
import android.util.Log
import kotlin.math.log

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("tagTd","oncreate")
    }
}