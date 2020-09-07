package com.maulikpract.di


import com.maulikpract.view.pract2.screen1.Practival2Screen1ViewModel
import com.maulikpract.view.pract2.screen2.Practival2Screen2ViewModel
import com.maulikpract.view.restaurant.RestaurantActivityViewModel
import com.maulikpract.view.restaurant.RestuarentActivity
import org.koin.dsl.module

val viewModleModule = module {
    single {
        RestaurantActivityViewModel(get())
    }

    factory {
        Practival2Screen1ViewModel(get())
    }

    factory {
        Practival2Screen2ViewModel(get())
    }

}