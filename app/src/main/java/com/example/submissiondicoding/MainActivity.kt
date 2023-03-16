package com.example.submissiondicoding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<movie>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        rvHeroes = findViewById(R.id.rv_movie)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()

    }


    private fun getListHeroes(): ArrayList<movie> {
        val datajudul = resources.getStringArray(R.array.data_judul)
        val datasinopsis = resources.getStringArray(R.array.data_sinopsis)
        val datatambah = resources.getStringArray(R.array.data_tambah)
        val datagambar = resources.obtainTypedArray(R.array.data_gambar)
        val listmovie = ArrayList<movie>()
        for (i in datajudul.indices) {
            val movies = movie(datajudul[i], datasinopsis[i], datatambah[i] ,datagambar.getResourceId(i, -1))
            listmovie.add(movies)
        }
        return listmovie
    }




    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listmovieAdapter = listmovieadapter(list)
        rvHeroes.adapter = listmovieAdapter

        listmovieAdapter.setOnItemClickCallback(object : listmovieadapter.OnItemClickCallback {
            override fun onItemClicked(data: movie) {
                val intentToDetail = Intent(this@MainActivity, detail::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
               startActivity(Intent(this, about::class.java))
            }
        }

        return super.onOptionsItemSelected(item)
    }



}