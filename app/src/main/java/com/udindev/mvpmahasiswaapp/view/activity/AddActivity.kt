package com.udindev.mvpmahasiswaapp.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.udindev.mahasiswaappnanangarifudin.model.action.ResponseAction
import com.udindev.mahasiswaappnanangarifudin.model.getdata.ResponseGetData
import com.udindev.mvpmahasiswaapp.R
import com.udindev.mvpmahasiswaapp.presenter.MahasiswaPresenter
import com.udindev.mvpmahasiswaapp.presenter.MahasiswaView
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity(), MahasiswaView {
    private val TAG = AddActivity::class.java.simpleName
    private lateinit var mahasiswaPresenter: MahasiswaPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        mahasiswaPresenter = MahasiswaPresenter(this)

        btn_add.setOnClickListener {
            val nama = edt_nama.text.toString()
            val alamat = edt_alamat.text.toString()
            val nohp = edt_nohp.text.toString()

            if (nama.isNotEmpty() && alamat.isNotEmpty() && nohp.isNotEmpty()) {
                mahasiswaPresenter.insertData(nama, nohp, alamat)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Pastikan data terisi semua", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSucces(msg: String, result: ResponseGetData) {
        TODO("Not yet implemented")
    }

    override fun onError(msg: String) {
        Log.e(TAG, "onAction: $msg")
    }

    override fun onAction(msg: String, result: ResponseAction) {
        Log.d(TAG, "onAction: $msg")
    }
}