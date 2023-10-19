package com.example.dagger.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger.component.DaggerUserComponent
import com.example.dagger.model.bean.DaggerDataSourceModuleComponent
import com.example.dagger.model.bean.DataSourceModuleComponent
import com.example.dagger.viewmodel.DaggerLoginViewModelModuleComponent
import com.example.dagger.viewmodel.LoginViewModel
import com.example.kotlinproject.R
import javax.inject.Inject

class DaggerActivity : AppCompatActivity() {
//    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        DaggerUserComponent.builder().loginViewModelModuleComponent(DaggerLoginViewModelModuleComponent.builder()
            .dataSourceModuleComponent(DaggerDataSourceModuleComponent.create()).build())
            .build().inject(this)
        Log.e("tagTd", "dagger==: " + viewModel.loadUserData())
    }
}