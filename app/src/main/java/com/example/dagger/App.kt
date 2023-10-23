package com.example.dagger

import android.app.Application
import android.util.Log
import com.example.dagger.model.bean.DaggerDataSourceModuleComponent
import com.example.dagger.viewmodel.DaggerLoginViewModelModuleComponent
import com.example.dagger.viewmodel.LoginViewModelModuleComponent

class App : Application() {
    lateinit var loginViewModelModuleComponent: LoginViewModelModuleComponent

    override fun onCreate() {
        super.onCreate()
        loginViewModelModuleComponent = DaggerLoginViewModelModuleComponent.builder().dataSourceModuleComponent(DaggerDataSourceModuleComponent.create()).build()
    }

}