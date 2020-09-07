package com.maulikpract.model

data class DeliveredTimming(
    val close_time: String,
    val created_at: String,
    val day: String,
    val hours_id: Int,
    val open_time: String,
    val restaurant_id: Int,
    val status: String
)