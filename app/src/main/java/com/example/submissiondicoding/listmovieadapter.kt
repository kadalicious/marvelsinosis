package com.example.submissiondicoding

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


@Suppress("DEPRECATION")
class listmovieadapter(private val listmovie: ArrayList<movie>) :
    RecyclerView.Adapter<listmovieadapter.listviewholder>() {



    private lateinit var onItemClickCallback: OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listviewholder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movie, parent, false)
        return listviewholder(view)
    }

    override fun onBindViewHolder(holder: listviewholder, position: Int) {
        val (name, description,tambah ,photo) = listmovie[position]
        holder.imggambar.setImageResource(photo)
        holder.tvName.text = name
        holder.tvtambah.text = tambah
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, detail::class.java)
            intentDetail.putExtra("key_movie", listmovie[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }


    }


    override fun getItemCount(): Int = listmovie.size

    class listviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imggambar: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val tvtambah: TextView = itemView.findViewById(R.id.tv_item_tambah)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: movie)
    }


}




