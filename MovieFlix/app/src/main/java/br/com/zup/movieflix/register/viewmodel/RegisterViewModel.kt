package br.com.zup.movieflix.register.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.repository.RegisterRepository

class RegisterViewModel :ViewModel() {
    private val repository = RegisterRepository()
    private var _response: MutableLiveData<RegisterModel> = MutableLiveData()
    var response: LiveData<RegisterModel> = _response

    fun authentication (registerModel: RegisterModel){
        try {
            _response.value = repository.verify(registerModel)
        }catch (ex: Exception){
            Log.i("Error", "------> ${ex.message}")
        }
    }
}