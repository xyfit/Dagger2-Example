package com.example.dagger2example

import android.app.Application
import com.example.dagger2example.di.component.AppComponent123
import com.example.dagger2example.di.component.DaggerAppComponent123

class App: Application() {
    companion object{
        lateinit var app: App
    }
    lateinit var appComponent: AppComponent123
    override fun onCreate() {
        super.onCreate()
        app = this

        appComponent = DaggerAppComponent123.create()
        appComponent.myInject(this)
    }
}