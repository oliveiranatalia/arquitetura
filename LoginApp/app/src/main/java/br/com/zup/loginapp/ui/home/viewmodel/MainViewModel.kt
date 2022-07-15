package br.com.zup.loginapp.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import br.com.zup.loginapp.domain.repository.AuthenticatonRepository

class MainViewModel:ViewModel() {
    private val repository = AuthenticatonRepository()

    fun getEmail() = repository.getEmail()

    fun logout() = repository.logout()
}