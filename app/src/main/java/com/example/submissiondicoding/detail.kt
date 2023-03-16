package com.example.submissiondicoding

import android.annotation.SuppressLint
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class detail : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


      //  val data = intent.getParcelableExtra<movie>("DATA")
        //Log.d("Detail Data", data?.judul.toString())

        val data = intent.getParcelableExtra<movie>("key_movie")

        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)
        val tvDetailName = findViewById<TextView>(R.id.detail_judul)
        val tvDetailDescription = findViewById<TextView>(R.id.detail_sinopsis)
        val tvDetailtambah = findViewById<TextView>(R.id.detail_tambah)


        if (data != null) {
            tvDetailName.text = data.judul
        }
        if (data != null) {
            tvDetailDescription.text = data.sinopsis
        }
        if (data != null) {
            tvDetailtambah.text = data.tambah
        }
        if (data != null) {
            ivDetailPhoto.setImageResource(data.gambar)
        }




    }
}