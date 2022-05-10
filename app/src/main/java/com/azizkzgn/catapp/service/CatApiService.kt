package com.azizkzgn.catapp.service

import com.azizkzgn.catapp.model.CatModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CatApiService {

    private val BASE_URL = "https://api.thecatapi.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CatApi::class.java)

    fun getData():Single<List<CatModel>>{
        return api.getCats()
    }
}