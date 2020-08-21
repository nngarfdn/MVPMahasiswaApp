package com.udindev.mvpmahasiswaapp.presenter

import com.udindev.mvpmahasiswaapp.network.ConfigRetrofit
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MahasiswaPresenter(private val mhsView: MahasiswaView) {

    fun getMahasiswa() {
        ConfigRetrofit.getRetrofit().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                mhsView.onSucces(response.message!! , response)
            }, { e ->
                mhsView.onError(e.localizedMessage)
            })
    }

    fun insertData(nama: String?, nohp: String?, alamat: String?) {
        ConfigRetrofit.getRetrofit().insertData(nama!!,nohp!!,alamat!!).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                mhsView.onAction(response.message!!, response)
            }, {
                e ->
                mhsView.onError(e.localizedMessage)
            })
    }

    fun updateData(id : String, nama: String?, nohp: String?, alamat: String?) {
        ConfigRetrofit.getRetrofit().updateData(id, nama!!,nohp!!,alamat!!).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                mhsView.onAction(response.message!!, response)
            }, {
                e ->
                mhsView.onError(e.localizedMessage)
            })
    }

     fun deleteData(id : String) {
        ConfigRetrofit.getRetrofit().deleteData(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                mhsView.onAction(response.message!!, response)
            }, {
                e ->
                mhsView.onError(e.localizedMessage)
            })
    }


}