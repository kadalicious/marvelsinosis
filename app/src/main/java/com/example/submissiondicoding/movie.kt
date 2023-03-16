package com.example.submissiondicoding

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class movie(
    val judul: String,
    val sinopsis: String,
    val tambah: String,
    val gambar: Int
) :Parcelable
