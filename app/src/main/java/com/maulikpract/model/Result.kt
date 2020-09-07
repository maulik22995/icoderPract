package com.maulikpract.model

data class Result(
    val is_display_image: String,
    val item_counts: Int,
    val menu_description: String,
    val menu_image: String,
    val menu_item_detail: ArrayList<MenuItemDetail>,
    val menu_name: String,
    val restaurant_id: Int,
    val restaurant_menu_id: Int
)