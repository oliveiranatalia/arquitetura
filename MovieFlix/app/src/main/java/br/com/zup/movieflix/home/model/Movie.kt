package br.com.zup.movieflix.home.model

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class Movie(
    var title: Int,
    var sinopse: Int,
    var image: Int,
    var director:Int
) : Parcelable