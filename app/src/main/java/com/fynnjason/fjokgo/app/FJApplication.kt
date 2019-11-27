package com.fynnjason.fjokgo.app

import android.app.Application
import com.fynnjason.fjokgo.http.FJHttpUtils

class FJApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FJHttpUtils.init(this)
    }
}