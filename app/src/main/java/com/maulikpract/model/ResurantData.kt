package com.maulikpract.model

data class RestaurantData(
    val Bravges: Bravges,
    val Result: List<Result>,
    val code: Int,
    val msg: String,
    val restaurant_details: RestaurantDetails,
    val restaurant_on_off: String
)