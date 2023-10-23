package com.example.dagger.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger.App
import com.example.dagger.component.DaggerUserComponent
import com.example.dagger.model.bean.DaggerDataSourceModuleComponent
import com.example.dagger.viewmodel.DaggerLoginViewModelModuleComponent
import com.example.dagger.viewmodel.LoginViewModel
import com.example.kotlinproject.R
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: LoginViewModel

//    @Inject
//    lateinit var viewModel1: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //全局单利学习
        //---------------------------------
        DaggerUserComponent.builder().loginViewModelModuleComponent((application as App).loginViewModelModuleComponent)
            .build().inject(this)
        //---------------------------------

        //activity局部单利学习
        //------------------------
//        DaggerUserComponent.builder().loginViewModelModuleComponent(DaggerLoginViewModelModuleComponent.builder()
//            .dataSourceModuleComponent(DaggerDataSourceModuleComponent.create()).build())
//            .build().inject(this)
        //------------------------



        //SubComponent学习
        //-----------------------------------
//        DaggerDataSourceModuleComponent.builder().build()//获得dataSourceModuleComponent
//            .getLoginViewModelModuleComponent(LoginViewModelModule())//获得loginViewModelModuleComponent
//            .getUserComponent()//获得UserComponent
//            .inject(this)
        //-----------------------------------

        Log.e("tagTd", "dagger==: " + viewModel.hashCode())
//        Log.e("tagTd", "dagger1==: " + viewModel1.hashCode())

        startActivity(Intent(this, DaggerV2Activity::class.java))
    }
}