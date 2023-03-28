package com.barryzea.cleancodeapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/****
 * Project CleanCodeApp
 * Created by Barry Zea H. on 28/3/23.
 * Copyright (c)  All rights reserved.
 ***/
@HiltAndroidApp
class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}