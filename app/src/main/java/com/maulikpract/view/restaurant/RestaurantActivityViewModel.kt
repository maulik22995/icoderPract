package com.maulikpract.view.restaurant

import androidx.lifecycle.viewModelScope
import com.maulikpract.api.request.RestaurantRequest
import com.maulikpract.base.BaseState
import com.maulikpract.base.BaseViewModel
import com.maulikpract.model.RestaurantData
import kotlinx.coroutines.launch

class RestaurantActivityViewModel(private val state: ResturantActivityState) : BaseViewModel() {
    override fun provideState(): BaseState = state
    lateinit var data : RestaurantData

    fun getResturantData() {
        state.resturantAPIState.postValue(RestaurantAPIState.Loading)
        state.isLoading.value = true
        viewModelScope.launch {
            runCatching {
                apiService.getRestaurant(RestaurantRequest())

            }.onSuccess {
                data = it
                state.isLoading.value = false
                it.let { response ->
                    state.resturantAPIState.postValue(RestaurantAPIState.Success(it))
                }
            }.onFailure {
                state.isLoading.value = false
                state.resturantAPIState.postValue(
                    RestaurantAPIState.Failure(
                        it
                    )
                )
            }
        }
    }
}