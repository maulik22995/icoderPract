package com.maulikpract.model

data class MenuItemDetail(
    val custom_details: List<Any>,
    val image: String,
    val is_alcoholic: String,
    val is_customization: Int,
    val is_sold_out: String,
    val item_description: String,
    val item_id: String,
    val item_images: List<ItemImage>,
    val item_name: String,
    val item_type: String,
    val mrp: String,
    val price: String,
    val quantity: Int,
    val restaurant_id: Int,
    val time_slot: String
)