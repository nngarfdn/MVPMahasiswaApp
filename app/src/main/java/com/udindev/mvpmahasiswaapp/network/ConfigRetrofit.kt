package com.udindev.mvpmahasiswaapp.network

import com.udindev.mahasiswaappnanangarifudin.config.MahasiswaService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ConfigRetrofit {

    companion object {
        fun getRetrofit(): MahasiswaService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.42.125/mentoring_kotlin_week4/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
            return retrofit.create(MahasiswaService::class.java)
        }
    }
}