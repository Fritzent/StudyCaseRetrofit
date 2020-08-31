package com.example.studycaseretrofit.pojo


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class GetPersonsResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("result")
    val result: List<Result>
) {
    @Parcelize
    data class Result(
        @SerializedName("CreatedAt")
        val createdAt: String,
        @SerializedName("DeletedAt")
        val deletedAt: String?,
        @SerializedName("first_name")
        var firstName: String,
        @SerializedName("ID")
        val iD: Int,
        @SerializedName("last_name")
        var lastName: String,
        @SerializedName("UpdatedAt")
        val updatedAt: String
    ): Parcelable
}