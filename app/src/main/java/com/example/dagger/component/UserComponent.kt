package com.example.dagger.component

import com.example.dagger.model.bean.DataSourceModule
import com.example.dagger.view.DaggerActivity
import com.example.dagger.viewmodel.LoginViewModelModuleComponent
import dagger.Component


//@Component
//interface UserComponent {
//    fun inject(activity: DaggerActivity)
//}

//module provider学习,针对两种情况可以使用module 和 provider
//--------------------------
//@Component(modules = [DataSourceModule::class])
//@Component(modules = [DataSourceModule::class, LoginViewModelModuleComponent::class])
//interface UserComponent {
//    fun inject(activity: DaggerActivity)
//}
//--------------------------

//Dependency 和 subComponent学习， 作用是为了不止用一个component去依赖多个module，可以利用component之间互相依赖的能力组成一个依赖链
//--------------------------
@Component(dependencies = [LoginViewModelModuleComponent::class])
interface UserComponent {
    fun inject(activity: DaggerActivity)
}
//--------------------------
