package com.example.studycaseretrofit.pojo


import com.google.gson.annotations.SerializedName

data class PutPersonResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("result")
    val result: String
) {
    data class Data(
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