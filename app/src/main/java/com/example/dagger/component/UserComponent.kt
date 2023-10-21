package com.example.dagger.component

import com.example.dagger.model.bean.DataSourceModule
import com.example.dagger.view.DaggerActivity
import com.example.dagger.viewmodel.ActivityScope
import com.example.dagger.viewmodel.LoginViewModelModuleComponent
import dagger.Component
import dagger.Subcomponent


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

//Dependency学习， 作用是各个模块可以单独分开依赖
//--------------------------
@ActivityScope
@Component(dependencies = [LoginViewModelModuleComponent::class])
interface UserComponent {
    fun inject(activity: DaggerActivity)
}
//--------------------------

//SubComponent学习， 作用是模块间相互耦合
//--------------------------
//@Subcomponent
//interface UserComponent {
//    fun inject(activity: DaggerActivity)
//}
//--------------------------
