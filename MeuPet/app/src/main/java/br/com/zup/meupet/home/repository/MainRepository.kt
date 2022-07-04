package br.com.zup.meupet.home.repository

import android.app.Application
import android.content.Context
import br.com.zup.meupet.NAME_KEY
import br.com.zup.meupet.PREFERENCE_KEY
import br.com.zup.meupet.home.model.MainModel

class MainRepository {

    fun authenticate(pet: MainModel, application: Application):MainModel{
        val pref = application.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE)
        pet.accessAuth = pet.name == pref.getString(NAME_KEY, "")
        return pet
    }
    fun getDataSaved(application: Application): MainModel{
        val pref = application.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE)
        val name = pref.getString(NAME_KEY,"").toString()
        return MainModel(name)
    }
}