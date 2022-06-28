package br.com.zup.movieflix.register.repository

import android.app.Application
import android.content.Context
import br.com.zup.movieflix.PREFERENCE_REGISTER_KEY
import br.com.zup.movieflix.USER_EMAIL_REGISTER_KEY
import br.com.zup.movieflix.USER_NAME_REGISTER_KEY
import br.com.zup.movieflix.USER_PASSWORD_REGISTER_KEY
import br.com.zup.movieflix.register.model.RegisterModel

class RegisterRepository {

    fun registration(register: RegisterModel, application:Application) {
        val pref = application.getSharedPreferences(PREFERENCE_REGISTER_KEY, Context.MODE_PRIVATE)
        val prefEditor = pref.edit()

        prefEditor.putString(USER_NAME_REGISTER_KEY, register.userName)
        prefEditor.putString(USER_EMAIL_REGISTER_KEY, register.email)
        prefEditor.putString(USER_PASSWORD_REGISTER_KEY, register.password)
        prefEditor.apply()
    }
}