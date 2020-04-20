@file:Suppress("UNCHECKED_CAST")

package com.example.earlybuddy_pattern

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.earlybuddy_pattern.data.model.Place
import com.example.earlybuddy_pattern.ui.visited.PlaceAdapter

@BindingAdapter("turnRed")
fun TextView.turnRed(boolean: Boolean) {
    visibility = View.VISIBLE
    if (boolean) {
        visibility = View.VISIBLE
    } else {
        visibility = View.GONE

    }
}

@BindingAdapter("setPlaceData")
fun RecyclerView.setData(placeData: List<Any>?) {
    when (placeData) {
        null -> {
        }
        else -> {
            if (placeData.isNotEmpty()) {
                (this.adapter as PlaceAdapter).setListData(placeData as List<Place>)
            }

        }
    }
}