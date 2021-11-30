package com.example.kumparanskilltest.model

data class UserAddressModel(
    var city: String? = null,
    var geo: UserGeoModel? = null,
    var street: String? = null,
    var suite: String? = null,
    var zipcode: String? = null
)