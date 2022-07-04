package br.com.zup.recursoshumanos.data.datasource.local.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Employee(private var name:String,
               private var hours:Int,
               private var value:Double
): Parcelable {
    fun getNome() = this.name
    fun getHoras() = this.hours
    fun getValor() = this.value
}
