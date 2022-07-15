package br.com.zup.loginapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(var email:String, var password:String): Parcelable