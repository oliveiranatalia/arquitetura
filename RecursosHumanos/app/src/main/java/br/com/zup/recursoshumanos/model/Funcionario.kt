package br.com.zup.recursoshumanos.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Funcionario(private var nome:String, private var horas:Int, private var valor:Double
): Parcelable {
    fun getNome() = this.nome
    fun getHoras() = this.horas
    fun getValor() = this.valor
}
