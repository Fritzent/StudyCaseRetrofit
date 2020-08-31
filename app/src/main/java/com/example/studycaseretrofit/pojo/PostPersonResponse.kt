package com.example.studycaseretrofit.pojo


import com.google.gson.annotations.SerializedName

data class PostPersonResponse(
    @SerializedName("result")
    val result: Result
) {
    data class Result(
        @SerializedName("CreatedAt")
        val createdAt: String,
        @SerializedName("DeletedAt")
        val deletedAt: Any,
        @SerializedName("first_name")
        val firstName: String,
        @SerializedName("ID")
        val iD: Int,
        @SerializedName("last_name")
        val lastName: String,
        @SerializedName("UpdatedAt")
        val updatedAt: String
    )
}