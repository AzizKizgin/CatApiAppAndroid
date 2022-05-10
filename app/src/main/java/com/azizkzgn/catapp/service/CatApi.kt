package com.azizkzgn.catapp.service

import com.azizkzgn.catapp.model.CatModel
import io.reactivex.Single
import retrofit2.http.GET

interface CatApi {

    //https://api.thecatapi.com/v1/breeds?api_key=bfe7223b-1946-4826-9825-3eaaf6f95b25

    @GET("v1/breeds?api_key=7d5f01e0-af89-4ec4-b5c5-7c3864edefbe")
    fun getCats():Single<List<CatModel>>
}