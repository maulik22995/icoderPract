package com.maulikpract.model

data class ItemImage(
    val created_at: String,
    val id: Int,
    val image_name: String,
    val restaurant_id: Int,
    val restaurant_menu_item_id: Int,
    val updated_at: String,
    val vendor_id: Int
)