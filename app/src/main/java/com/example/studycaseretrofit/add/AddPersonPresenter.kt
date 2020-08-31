package com.example.studycaseretrofit.add

import com.example.studycaseretrofit.network.ApiClient
import com.example.studycaseretrofit.pojo.PostPersonBody
import com.example.studycaseretrofit.pojo.PostPersonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddPersonPresenter(val listener: Listener) {

    fun addPerson(firstName : String, lastName: String){
        val person =
            PostPersonBody(
                firstName,
                lastName
            )

        ApiClient.apiService.addPerson(person).enqueue(object : Callback<PostPersonResponse> {
            override fun onFailure(call: Call<PostPersonResponse>, t: Throwable) {
                listener.onAddPersonFailure(t.toString())
            }

            override fun onResponse(
                call: Call<PostPersonResponse>,
                response: Response<PostPersonResponse>
            ) {
                listener.onAddPersonSuccess("Add Success")
            }
        })
    }

    interface Listener{
        fun onAddPersonSuccess(successMessage: String)
        fun onAddPersonFailure(failureMessage: String)
    }
}