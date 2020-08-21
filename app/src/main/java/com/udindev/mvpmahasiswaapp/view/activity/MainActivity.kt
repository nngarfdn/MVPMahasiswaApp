package com.udindev.mvpmahasiswaapp.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.iniudin.githubuserapp.adapter.MahasiswaAdapter
import com.udindev.mahasiswaappnanangarifudin.model.action.ResponseAction
import com.udindev.mahasiswaappnanangarifudin.model.getdata.ResponseGetData
import com.udindev.mvpmahasiswaapp.R
import com.udindev.mvpmahasiswaapp.presenter.MahasiswaPresenter
import com.udindev.mvpmahasiswaapp.presenter.MahasiswaView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MahasiswaView {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var mahasiswaPresenter: MahasiswaPresenter
    private lateinit var adapter: MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mahasiswaPresenter = MahasiswaPresenter(this)
        mahasiswaPresenter.getMahasiswa()

        fab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSucces(msg: String, result: ResponseGetData) {
        Log.d(TAG, "onSucces: $msg")
        Log.d(TAG, "onSucces: ${result.data}")

        adapter = MahasiswaAdapter(result.data)
        rv_list_mahasiswa.adapter = adapter
        initRecView()
    }

    override fun onError(msg: String) {
        Log.e(TAG, "onError: $msg")
    }

    private fun initRecView() {
        rv_list_mahasiswa.layoutManager = LinearLayoutManager(this)
        rv_list_mahasiswa.setHasFixedSize(true)
        adapter.notifyDataSetChanged()
    }

    override fun onAction(msg: String, result: ResponseAction) {
    }
}