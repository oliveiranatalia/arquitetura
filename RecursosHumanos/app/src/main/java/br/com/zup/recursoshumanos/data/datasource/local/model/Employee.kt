package br.com.zup.recursoshumanos.data.datasource.local.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "employee")
class Employee(
    @ColumnInfo(name = "name")
    private var name:String,
    @ColumnInfo(name = "hours")
    private var hours:Int,
    @ColumnInfo(name = "value")
    private var value:Double
): Parcelable