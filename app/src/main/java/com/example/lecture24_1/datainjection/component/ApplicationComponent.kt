package com.example.lecture24_1.datainjection.component

import com.example.lecture24_1.datainjection.module.ApplicationModule
import com.example.lecture24_1.model.repository.NetworkData
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(networkData: NetworkData)
}