package com.example.studycaseretrofit.update

import com.example.studycaseretrofit.network.ApiClient
import com.example.studycaseretrofit.pojo.GetPersonsResponse
import com.example.studycaseretrofit.pojo.PutPersonBody
import com.example.studycaseretrofit.pojo.PutPersonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditPersonPresenter (val listener: Listener) {
    fun updatePerson(result: GetPersonsResponse.Result){
        val objectPut = PutPersonBody(result.firstName, result.lastName)
        ApiClient.apiService.updatePerson(objectPut,result.iD.toString()).enqueue(object :
            Callback<PutPersonResponse> {

            override fun onFailure(call: Call<PutPersonResponse>, t: Throwable) {
                t.message?.let {
                    listener.onUpdatePersonFailed(it)
                }
            }

            override fun onResponse(
                call: Call<PutPersonResponse>,
                response: Response<PutPersonResponse>
            ) {
                listener.onUpdatePersonSuccess("Sukses mengubah Data Person")
            }
        })
    }


    interface Listener{
        fun onUpdatePersonSuccess(message: String)
        fun onUpdatePersonFailed(errorMessage: String)
    }
}