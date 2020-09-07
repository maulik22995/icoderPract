package com.maulikpract.api

import com.maulikpract.api.request.RestaurantRequest
import com.maulikpract.model.RestaurantData
import com.maulikpract.model.RestaurantDetails
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Provides remote APIs
 */
interface ApiService{

    @POST("/api/v3/restaurantmenus")
    suspend fun getRestaurant(@Body resurantRequest: RestaurantRequest): RestaurantData
}