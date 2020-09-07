package com.maulikpract.model

data class PickupTimming(
    val close_time: String,
    val created_at: String,
    val day: String,
    val open_time: String,
    val pickup_hours_id: Int,
    val restaurant_id: Int,
    val status: String
)