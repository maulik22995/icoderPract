package com.maulikpract.utils.listners

import android.view.View

interface OnItemClickListener {
     fun onItemClick(view : View, data : Any, position : Int)
}