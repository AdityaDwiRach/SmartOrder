package com.adr.smartorder.model.api

import com.adr.smartorder.model.PostLoginResponse
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @FormUrlEncoded
    @POST("apiv1")
    fun postLogin(
        @HeaderMap headers: Map<String, String>,
        @Field("method") method: String,
        @Field("password") password: String,
        @Field("email") email: String
    ): Call<PostLoginResponse>
}