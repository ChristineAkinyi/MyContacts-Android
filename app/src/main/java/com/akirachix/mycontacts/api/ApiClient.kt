package com.akirachix.mycontacts.api

import retrofit2.Retrofit

object ApiClient {
    val retrofit = Retrofit
        .Builder()
        .baseUrl("https://d58b-197-232-143-191.ngrok-free.app")
        .build()

    fun <T> buildApiClient(apiInterface: Class <T>): T{
        return retrofit.create(apiInterface)
    }
}