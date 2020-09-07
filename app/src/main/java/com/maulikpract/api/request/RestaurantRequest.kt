package com.maulikpract.api.request


data class RestaurantRequest(
    val date: String = "",
    val delivery_type_time_slots: Int = -1,
    val is_langauge: String = "E",
    val latitude: String = "23.04565431097748",
    val longitude: String = "72.51181852072477",
    val restaurant_id: String = "1334",
    val starttime: String = "",
    val vendor_id: String = "40818"
)
