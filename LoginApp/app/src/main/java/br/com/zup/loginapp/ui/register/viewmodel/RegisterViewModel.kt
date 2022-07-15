package br.com.zup.loginapp.ui.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.loginapp.constants.ERROR
import br.com.zup.loginapp.constants.REQUIRED
import br.com.zup.loginapp.domain.model.User
import br.com.zup.loginapp.domain.repository.AuthenticatonRepository

class RegisterViewModel : ViewModel(){
    private val repository = AuthenticatonRepository()

    private var _register = MutableLiveData<User>()
    var register: LiveData<User> = _register

    private var _error = MutableLiveData<String>()
    var error: LiveData<String> = _error

    fun dataValidate(user:User){
        when{
            user.email.isEmpty() -> _error.value = REQUIRED
            user.password.isEmpty() -> _error.value = REQUIRED
            else -> register(user)
        }
    }
    private fun register(user:User){
        try {
            repository.register(user.email, user.password)
        }catch(e:Exception){
           _error.value = ERROR
        }
    }
}