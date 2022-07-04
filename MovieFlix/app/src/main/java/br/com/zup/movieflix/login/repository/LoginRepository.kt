package br.com.zup.movieflix.login.repository

import android.app.Application
import android.content.Context
import br.com.zup.movieflix.*
import br.com.zup.movieflix.login.model.LoginModel

class LoginRepository {

    fun authenticate (login : LoginModel, application: Application) :LoginModel{
        val pref = application.getSharedPreferences(PREFERENCE_REGISTER_KEY, Context.MODE_PRIVATE)

        login.accessAuth = login.user == pref.getString(USER_EMAIL_REGISTER_KEY,"") &&
                login.password == pref.getString(USER_PASSWORD_REGISTER_KEY,"")
        return login
    }

    fun getDataSaved(application: Application): LoginModel {
        val pref = application.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE)

        val user = pref.getString(USER_NAME_LOGIN_KEY, "").toString()
        val password = pref.getString(USER_PASSWORD_LOGIN_KEY, "").toString()
        return LoginModel(user, password)
    }
}