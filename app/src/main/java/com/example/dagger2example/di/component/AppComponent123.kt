package com.example.dagger2example.di.component

import com.example.dagger2example.App
import com.example.dagger2example.InfoActivity
import com.example.dagger2example.MainActivity
import com.example.dagger2example.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
/*App module da bittadan ortiq singletone iwlatilgan bo'lsa buyergaham yoziliwi kk*/
@Component(modules = [AppModule::class])/*Bu class componentligi aytilmoqda va qancha modullarni o'zichiga oliwi etilmoqda*/
interface AppComponent123 {
    //inject nomlanadi
    fun myInject(app: App)
    fun myInject(mainActivity: MainActivity)
    fun myInject(mainActivity: InfoActivity)

}