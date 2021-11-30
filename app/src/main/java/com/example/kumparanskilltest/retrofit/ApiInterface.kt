package com.example.kumparanskilltest.retrofit

import com.example.kumparanskilltest.model.*
import com.example.kumparanskilltest.model.response.GetAlbumResponse
import com.example.kumparanskilltest.model.response.GetCommentsResponse
import com.example.kumparanskilltest.model.response.GetThumbnailPhotosResponse
import com.example.kumparanskilltest.model.response.GetUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("posts")
    fun getPosts(): Call<AllPostModel>

    @GET("posts/{id}")
    fun getDetailPost(
        @Path("id") paramId: String?,
    ): Call<PostModel>

    @GET("comments")
    fun getComment(
        @Query("postId") postId: String?,
    ): Call<GetCommentsResponse>

    @GET("users")
    fun getUsers(): Call<GetUserResponse>

    @GET("users")
    fun getDetailUsers(
        @Query("id") paramId: String?,
    ): Call<GetUserResponse>

    @GET("albums")
    fun getAlbum(
        @Query("userId") paramId: String?,
    ): Call<GetAlbumResponse>

    @GET("photos/{id}")
    fun getDetailPhotos(
        @Path("id") paramId: String?,
    ): Call<PhotosModel>

    @GET("photos")
    fun getThumbnailPhotos(
        @Query("albumId") paramId: String?,
    ): Call<GetThumbnailPhotosResponse>

}