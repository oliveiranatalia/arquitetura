package br.com.zup.musicafavorita.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album(
    var image: Int,
    var title: String,
    var description: String,
    var informations:String
): Parcelable
