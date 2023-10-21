package com.example.dagger.viewmodel

import com.example.dagger.component.UserComponent
import com.example.dagger.model.bean.DataSource
import com.example.dagger.model.bean.DataSourceModuleComponent
import com.example.dagger.model.bean.LocalUser
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton


//module provider学习,针对两种情况可以使用module 和 provider
//--------------------------
class LoginViewModel @Inject constructor(@LocalUser private val dataSource: DataSource) {
    fun loadUserData(): String {
        return dataSource.load()
    }
}
//--------------------------


//多module学习,component要依赖多个module
//--------------------------
@Module
class LoginViewModelModule {

    @Singleton
    @Provides
    fun provideLoginModel(@LocalUser dataSource: DataSource) : LoginViewModel{
        return LoginViewModel(dataSource)
    }
}
//--------------------------


//Dependency学习， 作用是各个模块可以单独分开依赖
//--------------------------
@Singleton
@Component(modules = [LoginViewModelModule::class], dependencies = [DataSourceModuleComponent::class])
interface LoginViewModelModuleComponent{
    fun getUserRemoteData(): LoginViewModel
}
//--------------------------


//SubComponent学习， 作用是模块间相互耦合
//--------------------------
//@Subcomponent(modules = [LoginViewModelModule::class])
//interface LoginViewModelModuleComponent{
//    fun getUserComponent(): UserComponent
//}
//--------------------------

//普通inject学习
//--------------------------
//class LoginViewModel @Inject constructor(private val userRepository: UserRepository) {
//    fun loadUserData(): String {
//        return userRepository.load()
//    }
//}
//--------------------------


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope
