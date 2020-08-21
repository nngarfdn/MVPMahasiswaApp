package com.udindev.mvpmahasiswaapp.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.udindev.mahasiswaappnanangarifudin.model.action.ResponseAction
import com.udindev.mahasiswaappnanangarifudin.model.getdata.DataItem
import com.udindev.mahasiswaappnanangarifudin.model.getdata.ResponseGetData
import com.udindev.mvpmahasiswaapp.R
import com.udindev.mvpmahasiswaapp.presenter.MahasiswaPresenter
import com.udindev.mvpmahasiswaapp.presenter.MahasiswaView
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity(), MahasiswaView {
    private val TAG = UpdateActivity::class.java.simpleName
    private lateinit var mahasiswaPresenter: MahasiswaPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        mahasiswaPresenter = MahasiswaPresenter(this)

        val mahasiswa = intent.getParcelableExtra<DataItem>(DetailActivity.EXTRA_MAHASISWA)

        edt_nama.setText(mahasiswa?.mahasiswaNama)
        edt_alamat.setText(mahasiswa?.mahasiswaAlamat)
        edt_nohp.setText(mahasiswa?.mahasiswaNohp)

                btn_update.setOnClickListener {
            val id = mahasiswa?.idMahasiswa
            val nama = edt_nama.text.toString()
            val alamat = edt_alamat.text.toString()
            val nohp = edt_nohp.text.toString()

            if (nama.isNotEmpty() && alamat.isNotEmpty() && nohp.isNotEmpty()) {
                mahasiswaPresenter.updateData(id!!, nama, nohp, alamat)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Pastikan data terisi semua", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSucces(msg: String, result: ResponseGetData) {

    }

    override fun onError(msg: String) {
        Log.e(TAG, "onError: $msg")
    }

    override fun onAction(msg: String, result: ResponseAction) {
        Log.d(TAG, "onAction: $msg")
    }
}