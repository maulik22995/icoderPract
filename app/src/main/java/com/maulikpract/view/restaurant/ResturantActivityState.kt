package com.maulikpract.view.restaurant

import androidx.lifecycle.MutableLiveData
import com.maulikpract.base.BaseState
import com.maulikpract.model.RestaurantData
import com.maulikpract.model.RestaurantDetails

class ResturantActivityState : BaseState{
    val coverImageUrl = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()
    val resturantAPIState = MutableLiveData<RestaurantAPIState>()
}

/**
 * SignIn api State
 */
sealed class RestaurantAPIState {
    object Loading : RestaurantAPIState()
    data class Success(val data: RestaurantData) : RestaurantAPIState()
    data class Failure(val throwable: Throwable) : RestaurantAPIState()
}