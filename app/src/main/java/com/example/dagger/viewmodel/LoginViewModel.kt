package com.example.dagger.viewmodel

import com.example.dagger.model.bean.DataSource
import com.example.dagger.model.bean.DataSourceModuleComponent
import com.example.dagger.model.bean.LocalUser
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject


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
    @Provides
    fun provideLoginModel(@LocalUser dataSource: DataSource) : LoginViewModel{
        return LoginViewModel(dataSource)
    }
}
//--------------------------


//Dependency 和 subComponent学习， 作用是为了不止用一个component去依赖多个module，可以利用component之间互相依赖的能力组成一个依赖链
@Component(modules = [LoginViewModelModule::class], dependencies = [DataSourceModuleComponent::class])
interface LoginViewModelModuleComponent{
    fun getUserRemoteData(): LoginViewModel
}



//普通inject学习
//--------------------------
//class LoginViewModel @Inject constructor(private val userRepository: UserRepository) {
//    fun loadUserData(): String {
//        return userRepository.load()
//    }
//}
//--------------------------
