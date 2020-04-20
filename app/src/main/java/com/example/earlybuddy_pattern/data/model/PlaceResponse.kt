package com.example.earlybuddy_pattern.data.model

data class PlaceResponse(
    val status: Boolean,
    val message: List<Place>

)

data class Place(
    val placeName :String,
    val addressName: String,
    val roadAddressName: String,
    val x: String,
    val y: String
)