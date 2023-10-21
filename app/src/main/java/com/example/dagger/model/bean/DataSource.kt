package com.example.dagger.model.bean

import com.example.dagger.viewmodel.LoginViewModelModule
import com.example.dagger.viewmodel.LoginViewModelModuleComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Qualifier

interface DataSource {
    fun load(): String
}

//module provider学习,针对两种情况可以使用module 和 provider
//--------------------------


//假设是一个封闭类------module provider学习
class UserService private constructor() {
    class Builder {
        fun build(): UserService = UserService()
    }

    fun load(): String = "UserService.load()"
}

class UserLocalDataSource @Inject constructor(private val userService: UserService): DataSource{
    override fun load(): String {
        return userService.load() + "  UserLocalDataSource.load()"
    }
}

class UserRemoteDataSource @Inject constructor(private val userService: UserService): DataSource{
    override fun load(): String {
        return userService.load() + "  UserRemoteDataSource.load()"
    }
}

//module作用就是生成并提供Bean类，不管方法名或module名是什么，只需生成DataSource类型的数据就行
//--------------------------
//@Module
//class DataSourceModule{
//    @Provides
//    fun getUserLocalData(): DataSource{
//        return UserLocalDataSource(UserService.Builder().build())
//    }
//}
//--------------------------

//Qualifier 和 Name学习
//--------------------------
@Module
class DataSourceModule{
    @Provides
    @LocalUser
    fun getUserLocalData(): DataSource{
        return UserLocalDataSource(UserService.Builder().build())
    }

    @Provides
    @RemoteUser
    fun getUserRemoteData(): DataSource{
        return UserRemoteDataSource(UserService.Builder().build())
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LocalUser

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RemoteUser
//--------------------------


//Dependency学习， 作用是各个模块可以单独分开依赖
//--------------------------
@Component(modules = [DataSourceModule::class])
interface DataSourceModuleComponent{
    @LocalUser
    fun getUserLocalData(): DataSource

    @RemoteUser
    fun getUserRemoteData(): DataSource
}
//--------------------------


//SubComponent学习， 作用是模块间相互耦合
//--------------------------
//@Component(modules = [DataSourceModule::class])
//interface DataSourceModuleComponent{
//    fun getLoginViewModelModuleComponent(loginViewModelModule: LoginViewModelModule): LoginViewModelModuleComponent
//}
//--------------------------



//普通inject学习
//--------------------------
//class UserLocalDataSource @Inject constructor(): DataSource{
//    override fun load(): String {
//        return "UserLocalDataSource.load()"
//    }
//}
//
//class UserRemoteDataSource @Inject constructor(): DataSource{
//    override fun load(): String {
//        return "UserRemoteDataSource.load()"
//    }
//}
//--------------------------