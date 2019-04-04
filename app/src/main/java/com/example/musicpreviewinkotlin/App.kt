package com.example.musicpreviewinkotlin

import android.app.Application
import com.example.musicpreviewinkotlin.dagger.AppComponent
import com.example.musicpreviewinkotlin.dagger.DaggerAppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}