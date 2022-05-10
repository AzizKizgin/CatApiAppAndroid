package com.azizkzgn.catapp.model

import com.google.gson.annotations.SerializedName

data class CatModel(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("origin")
    val origin: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("reference_image_id")
    val imageId:String?

    )