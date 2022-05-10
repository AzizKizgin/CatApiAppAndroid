package com.azizkzgn.catapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azizkzgn.catapp.model.CatModel
import com.azizkzgn.catapp.service.CatApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FeedViewModel: ViewModel() {

    private val catApiService = CatApiService()
    private val disposable = CompositeDisposable()
    val cats = MutableLiveData<List<CatModel>>()

    fun refreshData(){
        getFromApi()
    }

    private fun getFromApi(){
        disposable.add(
            catApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<CatModel>>(){
                    override fun onSuccess(t: List<CatModel>) {
                        cats.value=t
                    }

                    override fun onError(e: Throwable) {

                    }


                })
        )
    }
}