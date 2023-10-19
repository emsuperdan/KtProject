package com.example.dagger.model

import com.example.dagger.model.bean.DataSource
import com.example.dagger.model.bean.UserLocalDataSource
import com.example.dagger.model.bean.UserRemoteDataSource
import javax.inject.Inject

//普通inject学习
//--------------------------
//class UserRepository @Inject constructor(private val userLocalDataSource: UserLocalDataSource, private val userRemoteDataSource: UserRemoteDataSource) {
//    fun load(): String{
//        return "${userLocalDataSource.load()} - ${userRemoteDataSource.load()}"
//    }
//}
//--------------------------


