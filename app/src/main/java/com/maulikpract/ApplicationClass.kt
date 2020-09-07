package com.maulikpract

import android.app.Application
import com.maulikpract.di.appModule
import com.maulikpract.di.netWorkModule
import com.maulikpract.di.stateModule
import com.maulikpract.di.viewModleModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(applicationContext)
            modules(listOf(appModule,netWorkModule, stateModule, viewModleModule))
        }
    }

}