package com.example.kumparanskilltest.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kumparanskilltest.model.AllPostModel
import com.example.kumparanskilltest.model.response.GetCommentsResponse
import com.example.kumparanskilltest.model.PhotosModel
import com.example.kumparanskilltest.model.PostModel
import com.example.kumparanskilltest.model.UserDataModel
import com.example.kumparanskilltest.model.response.GetAlbumResponse
import com.example.kumparanskilltest.model.response.GetThumbnailPhotosResponse
import com.example.kumparanskilltest.model.response.GetUserResponse
import com.example.kumparanskilltest.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AllRepository {
    var photoDetailResponse = MutableLiveData<PhotosModel>()
    var allPostResponse = MutableLiveData<AllPostModel>()
    var allUserResponse = MutableLiveData<GetUserResponse>()
    var detailPostResponse = MutableLiveData<PostModel>()
    var detailUserResponse = MutableLiveData<GetUserResponse>()
    var commentPostResponse = MutableLiveData<GetCommentsResponse>()
    var getAlbumResponse = MutableLiveData<GetAlbumResponse>()
    var getThumbnailPhotosResponse = MutableLiveData<GetThumbnailPhotosResponse>()

    fun getPhotoDetail(id: String) {

        val call = RetrofitClient.apiInterface.getDetailPhotos(paramId = id)

        call.enqueue(object : Callback<PhotosModel> {
            override fun onFailure(call: Call<PhotosModel>, t: Throwable) {
                Log.v("Error : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<PhotosModel>,
                response: Response<PhotosModel>
            ) {
                photoDetailResponse.value = response.body()
            }
        })
    }

    fun getAllPost(): MutableLiveData<AllPostModel> {

        val call = RetrofitClient.apiInterface.getPosts()

        call.enqueue(object : Callback<AllPostModel> {
            override fun onFailure(call: Call<AllPostModel>, t: Throwable) {
                Log.v("Error : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<AllPostModel>,
                response: Response<AllPostModel>
            ) {
                allPostResponse.value = response.body()
            }
        })

        return allPostResponse
    }

    fun getPostDetail(id: String): MutableLiveData<PostModel> {

        val call = RetrofitClient.apiInterface.getDetailPost(paramId = id)

        call.enqueue(object : Callback<PostModel> {
            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                Log.v("Error : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<PostModel>,
                response: Response<PostModel>
            ) {
                detailPostResponse.value = response.body()
            }
        })

        return detailPostResponse
    }

    fun getCommentsPost(id: String): MutableLiveData<GetCommentsResponse> {

        val call = RetrofitClient.apiInterface.getComment(postId = id)

        call.enqueue(object : Callback<GetCommentsResponse> {
            override fun onFailure(call: Call<GetCommentsResponse>, t: Throwable) {
                Log.v("Error : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<GetCommentsResponse>,
                response: Response<GetCommentsResponse>
            ) {
                commentPostResponse.value = response.body()
            }
        })

        return commentPostResponse
    }

    fun getAllUser(): MutableLiveData<GetUserResponse> {

        val call = RetrofitClient.apiInterface.getUsers()

        call.enqueue(object : Callback<GetUserResponse> {
            override fun onFailure(call: Call<GetUserResponse>, t: Throwable) {
                Log.v("Error : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<GetUserResponse>,
                response: Response<GetUserResponse>
            ) {
                allUserResponse.value = response.body()
            }
        })

        return allUserResponse
    }

    fun getDetailUser(id: String): MutableLiveData<GetUserResponse> {

        val call = RetrofitClient.apiInterface.getDetailUsers(paramId = id)

        call.enqueue(object : Callback<GetUserResponse> {
            override fun onFailure(call: Call<GetUserResponse>, t: Throwable) {
                Log.v("Error : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<GetUserResponse>,
                response: Response<GetUserResponse>
            ) {
                detailUserResponse.value = response.body()
            }
        })

        return detailUserResponse
    }

    fun getAlbum(userId: String): MutableLiveData<GetAlbumResponse> {

        val call = RetrofitClient.apiInterface.getAlbum(userId)

        call.enqueue(object : Callback<GetAlbumResponse> {
            override fun onFailure(call: Call<GetAlbumResponse>, t: Throwable) {
                Log.v("Error : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<GetAlbumResponse>,
                response: Response<GetAlbumResponse>
            ) {
                getAlbumResponse.value = response.body()
            }
        })

        return getAlbumResponse
    }

    fun getThumbailPhoto(albumId: String): MutableLiveData<GetThumbnailPhotosResponse> {

        val call = RetrofitClient.apiInterface.getThumbnailPhotos(albumId)

        call.enqueue(object : Callback<GetThumbnailPhotosResponse> {
            override fun onFailure(call: Call<GetThumbnailPhotosResponse>, t: Throwable) {
                Log.v("Error : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<GetThumbnailPhotosResponse>,
                response: Response<GetThumbnailPhotosResponse>
            ) {
                getThumbnailPhotosResponse.value = response.body()
            }
        })

        return getThumbnailPhotosResponse
    }
}