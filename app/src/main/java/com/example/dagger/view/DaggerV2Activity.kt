package com.example.dagger.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger.model.bean.DaggerDataSourceModuleComponent
import com.example.dagger.model.bean.DataSourceModuleComponent
import com.example.dagger.viewmodel.*
import com.example.kotlinproject.R
import dagger.Component
import dagger.Subcomponent
import javax.inject.Inject

class DaggerV2Activity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        DaggerUserV2Component.builder().loginViewModelModuleComponent(DaggerLoginViewModelModuleComponent.builder()
            .dataSourceModuleComponent(DaggerDataSourceModuleComponent.create()).build())
            .build().inject(this)
//        DaggerDataSourceModuleComponent.builder().build()//获得dataSourceModuleComponent
//            .getLoginViewModelModuleComponent(LoginViewModelModule())//获得loginViewModelModuleComponent
//            .getUserComponent()//获得UserComponent
//            .inject(this)

        Log.e("tagTd", "dagger1==: " + viewModel.hashCode())
    }
}

//Dependency学习， 作用是各个模块可以单独分开依赖
//--------------------------
@ActivityScope
@Component(dependencies = [LoginViewModelModuleComponent::class])
interface UserV2Component {
    fun inject(activity: DaggerV2Activity)
}
//--------------------------