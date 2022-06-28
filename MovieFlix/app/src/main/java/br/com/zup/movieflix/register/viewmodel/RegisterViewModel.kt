package br.com.zup.movieflix.register.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.zup.movieflix.*
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.repository.RegisterRepository

class RegisterViewModel (application: Application): AndroidViewModel(application) {
    private val repository = RegisterRepository()

    val pref = application.getSharedPreferences(PREFERENCE_REGISTER_KEY, Context.MODE_PRIVATE)
    val prefEditor = pref.edit()

    private var _response: MutableLiveData<RegisterModel> = MutableLiveData()
    val response: LiveData<RegisterModel> = _response

    private val _savedDataFlag: MutableLiveData<Boolean> = MutableLiveData()
    val savedDataFlag: LiveData<Boolean> = _savedDataFlag

    private val _savedData: MutableLiveData<RegisterModel> = MutableLiveData()
    val savedData: LiveData<RegisterModel> = _savedData

    fun registration(register: RegisterModel, flagSaveData:Boolean){
        try{
            prefEditor.putBoolean(SAVE_USER_PASS_FLAG_KEY, flagSaveData)
            if(flagSaveData) {
                prefEditor.putString(USER_NAME_REGISTER_KEY, register.userName)
                prefEditor.putString(USER_EMAIL_REGISTER_KEY, register.email)
                prefEditor.putString(USER_PASSWORD_REGISTER_KEY, register.password)
                prefEditor.apply()
            }else{
                prefEditor.remove(USER_NAME_REGISTER_KEY)
                prefEditor.remove(USER_EMAIL_REGISTER_KEY)
                prefEditor.remove(USER_PASSWORD_REGISTER_KEY)
                prefEditor.apply()
            }
            _response.value = repository.validate(register)
        }catch (e: Exception){
            Log.e("Error", "------> ${e.message}")
        }
    }
    fun getDataSaved(){
        try{
            val name = pref.getString(USER_NAME_REGISTER_KEY,"").toString()
            val email = pref.getString(USER_EMAIL_REGISTER_KEY, "").toString()
            val password = pref.getString(USER_PASSWORD_REGISTER_KEY,"").toString()
            val register = RegisterModel(name,email, password)
            _savedData.value = register
            _savedDataFlag.value = pref.getBoolean(SAVE_USER_PASS_FLAG_KEY,false)
        }catch (e:Exception){
            Log.e("Error", "------> ${e.message}")
        }
    }
}