package com.example.rickandmortyhomeversion.main.api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OriginResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
) : Parcelable