package com.udindev.mvpmahasiswaapp.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.udindev.mahasiswaappnanangarifudin.model.action.ResponseAction
import com.udindev.mahasiswaappnanangarifudin.model.getdata.DataItem
import com.udindev.mahasiswaappnanangarifudin.model.getdata.ResponseGetData
import com.udindev.mvpmahasiswaapp.R
import com.udindev.mvpmahasiswaapp.presenter.MahasiswaPresenter
import com.udindev.mvpmahasiswaapp.presenter.MahasiswaView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), MahasiswaView {

    private val TAG = DetailActivity::class.java.simpleName
    private lateinit var mahasiswaPresenter: MahasiswaPresenter

    companion object {
        const val EXTRA_MAHASISWA = "extra_mahasiswa"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mahasiswaPresenter = MahasiswaPresenter(this)
        val mahasiswa = intent.getParcelableExtra<DataItem>(EXTRA_MAHASISWA)

        txt_nama.text = "Nama Mahasiswa   : ${mahasiswa?.mahasiswaNama}"
        txt_alamat.text = "Alamat Mahasiswa : ${mahasiswa?.mahasiswaAlamat}"
        txt_nohp.text = "Nomor HP         : ${mahasiswa?.mahasiswaNohp} "
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_action, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val mahasiswa = intent.getParcelableExtra<DataItem>(EXTRA_MAHASISWA)
        val id = item.itemId

        if (id == R.id.action_edit) {
            val intent = Intent(this, UpdateActivity::class.java)
            intent.putExtra(EXTRA_MAHASISWA, mahasiswa)
            startActivity(intent)
            return true
        }
        if (id == R.id.action_delete) {
            mahasiswaPresenter.deleteData(mahasiswa?.idMahasiswa!!)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
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