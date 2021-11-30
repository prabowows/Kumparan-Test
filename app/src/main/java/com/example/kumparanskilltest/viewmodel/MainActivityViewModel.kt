package com.example.kumparanskilltest.viewmodel

import androidx.lifecycle.*
import com.example.kumparanskilltest.model.AllPostModel
import com.example.kumparanskilltest.model.response.GetUserResponse
import com.example.kumparanskilltest.repository.AllRepository

class MainActivityViewModel : ViewModel() {

    var listAllPost: MutableLiveData<AllPostModel>? = null
    var detailUser: MutableLiveData<GetUserResponse>? = null

    fun getAllPost () : LiveData<AllPostModel>? {
        listAllPost = AllRepository.getAllPost()
        return listAllPost
    }

    fun getDetailUser(id: String): LiveData<GetUserResponse>? {
        detailUser = AllRepository.getDetailUser(id)
        return detailUser
    }

}