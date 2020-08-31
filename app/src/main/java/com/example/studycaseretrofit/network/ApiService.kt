package com.example.studycaseretrofit.network

import com.example.studycaseretrofit.pojo.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("persons")
    fun getAllPersons() : Call<GetPersonsResponse>

    //Method Post
    @POST("person")
    fun addPerson(@Body body: PostPersonBody) : Call<PostPersonResponse>

    //Method put
    @PUT("person/{id}")
    fun updatePerson(@Body body: PutPersonBody, @Path("id") id: String) : Call<PutPersonResponse>

    //Method Delete
    @DELETE("person/{id}")
    fun deletePerson(@Path("id") id: String) : Call<DeletePersonResponse>
}