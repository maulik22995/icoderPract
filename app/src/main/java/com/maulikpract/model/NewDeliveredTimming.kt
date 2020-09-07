package com.maulikpract.model

data class NewDeliveredTimming(
    val close_time: String,
    val created_at: String,
    val date: String,
    val day: String,
    val hours_id: Int,
    val open_time: String,
    val restaurant_id: Int,
    val status: String
)