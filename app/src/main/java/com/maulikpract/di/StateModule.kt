package com.maulikpract.di


import com.maulikpract.view.pract2.screen1.Practival2Screen1State
import com.maulikpract.view.pract2.screen2.Practival2Screen2State
import com.maulikpract.view.restaurant.ResturantActivityState
import org.koin.dsl.module

val stateModule = module {
    factory {
        ResturantActivityState()
    }

    factory {
        Practival2Screen1State()
    }

    factory {
        Practival2Screen2State()
    }

}