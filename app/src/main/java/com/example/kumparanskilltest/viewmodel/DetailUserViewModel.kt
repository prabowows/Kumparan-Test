package com.example.kumparanskilltest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kumparanskilltest.model.response.GetCommentsResponse
import com.example.kumparanskilltest.model.PostModel
import com.example.kumparanskilltest.model.UserDataModel
import com.example.kumparanskilltest.model.response.GetAlbumResponse
import com.example.kumparanskilltest.model.response.GetThumbnailPhotosResponse
import com.example.kumparanskilltest.model.response.GetUserResponse
import com.example.kumparanskilltest.repository.AllRepository

class DetailUserViewModel : ViewModel() {

    var detailUser: MutableLiveData<GetUserResponse>? = null
    var userAlbum: MutableLiveData<GetAlbumResponse>? = null
    var userPhotoThumbnail: MutableLiveData<GetThumbnailPhotosResponse>? = null

    fun getDetailUser(id: String): LiveData<GetUserResponse>? {
        detailUser = AllRepository.getDetailUser(id)
        return detailUser
    }

    fun getAlbumUser(id: String): LiveData<GetAlbumResponse>? {
        userAlbum = AllRepository.getAlbum(id)
        return userAlbum
    }

    fun getThumbnailPhotoUser(id: String): LiveData<GetThumbnailPhotosResponse>? {
        userPhotoThumbnail = AllRepository.getThumbailPhoto(id)
        return userPhotoThumbnail
    }

}