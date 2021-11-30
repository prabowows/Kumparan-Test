package com.example.kumparanskilltest.model

data class UserDataModel(
    var address: UserAddressModel? = null,
    var company: UserCompanyModel? = null,
    var email: String? = null,
    var id: Int? = null,
    var name: String? = null,
    var phone: String? = null,
    var username: String? = null,
    var website: String? = null
)