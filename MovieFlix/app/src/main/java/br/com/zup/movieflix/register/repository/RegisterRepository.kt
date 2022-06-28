package br.com.zup.movieflix.register.repository

import br.com.zup.movieflix.register.model.RegisterModel

class RegisterRepository {

    fun verify(model: RegisterModel): RegisterModel? {
        return when {
            model.userName.isNotEmpty() && model.userName.isNotBlank()
                    || model.email.isNotEmpty() && model.email.isNotBlank()
                    || model.password.isNotEmpty() && model.password.isNotBlank() -> model
            else -> null
        }
    }
}