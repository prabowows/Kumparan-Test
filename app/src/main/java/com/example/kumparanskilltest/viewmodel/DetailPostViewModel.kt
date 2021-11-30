package com.example.kumparanskilltest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kumparanskilltest.model.response.GetCommentsResponse
import com.example.kumparanskilltest.model.PostModel
import com.example.kumparanskilltest.model.response.GetUserResponse
import com.example.kumparanskilltest.repository.AllRepository

class DetailPostViewModel : ViewModel() {

    var detailPost: MutableLiveData<PostModel>? = null
    var listComment: MutableLiveData<GetCommentsResponse>? = null
    var detailUser: MutableLiveData<GetUserResponse>? = null

    fun getDetailPost(id: String): LiveData<PostModel>? {
        detailPost = AllRepository.getPostDetail(id)
        return detailPost
    }

    fun getComment(id: String): LiveData<GetCommentsResponse>? {
        listComment = AllRepository.getCommentsPost(id)
        return listComment
    }

    fun getDetailUser(id: String): LiveData<GetUserResponse>? {
        detailUser = AllRepository.getDetailUser(id)
        return detailUser
    }

}