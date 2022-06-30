package br.com.zup.movieflix.moviedetail.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DirectorModel(
    var name: Int,
    var info: Int
) : Parcelable
