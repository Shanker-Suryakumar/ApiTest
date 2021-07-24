package com.kotlin.apitest.views

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import java.util.*

interface MyEndPoints {
    @GET("A0CgArX3")
    fun getCategories(): Call<ResponseBody>

    @GET("Xt12uVhM")
    fun getJsonResponse(): Call<ResponseBody>
}