package br.com.zup.musicafavorita.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Album (private val image:Int, private val name: String,
             private val desc:String, private val info:String
): Parcelable {
    fun getImage() = this.image
    fun getName() = this.name
    fun getDesc() = this.desc
    fun getInfo() = this.info
}

