package com.udindev.mvpmahasiswaapp.presenter

import com.udindev.mahasiswaappnanangarifudin.model.action.ResponseAction
import com.udindev.mahasiswaappnanangarifudin.model.getdata.ResponseGetData

interface MahasiswaView {

    fun onSucces(msg : String, result : ResponseGetData)
    fun onError(msg: String)
    fun onAction(msg: String, result: ResponseAction)
}