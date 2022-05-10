package com.azizkzgn.catapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azizkzgn.catapp.model.CatModel

class DetailViewModel:ViewModel() {
    val cat = MutableLiveData<CatModel>()
}