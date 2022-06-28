package br.com.zup.movieflix.register.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.repository.RegisterRepository

class RegisterViewModel (application: Application): AndroidViewModel(application) {
    private val repository = RegisterRepository()

    private var _response: MutableLiveData<RegisterModel> = MutableLiveData()
    val response: LiveData<RegisterModel> = _response

    private val _savedData: MutableLiveData<RegisterModel> = MutableLiveData()
    val savedData: LiveData<RegisterModel> = _savedData

    fun validate(register: RegisterModel){
        try{
            repository.registration(register, getApplication())
        }catch (e: Exception){
            Log.e("Error", "------> ${e.message}")
        }
    }
}