package com.akirachix.mycontacts.api

import com.akirachix.mycontacts.model.SelfieResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiInterface {

    @POST("/selfie")
    suspend fun postPhoto(
        @Part image: MultipartBody.Part,
        @Part caption: MultipartBody.Part,
        @Part id: MultipartBody.Part
    ):Response<SelfieResponse>
}