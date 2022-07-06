package br.com.zup.recursoshumanos.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "employee")
class Employee(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "name")
    var name:String,

    @ColumnInfo(name = "hours")
    var hours:Int,

    @ColumnInfo(name = "value")
    var value:Double
): Parcelable