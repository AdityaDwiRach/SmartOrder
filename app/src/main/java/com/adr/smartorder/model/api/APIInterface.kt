package com.adr.smartorder.model.api

import com.adr.smartorder.model.GetProdGroupDtRes
import com.adr.smartorder.model.GetProdGroupLsRes
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

    @FormUrlEncoded
    @POST("apiv1")
    fun getProdGroupList(
        @HeaderMap headers: Map<String, String>,
        @Field("method") method: String,
        @Field("page") page: String,
        @Field("offset") offset: String,
        @Field("keyword") keyword: String
    ): Call<GetProdGroupLsRes>

    @FormUrlEncoded
    @POST("apiv1")
    fun getProdGroupData(
        @HeaderMap headers: Map<String, String>,
        @Field("method") method: String,
        @Field("product_group_id") productGroupId: String
    ): Call<GetProdGroupDtRes>
}