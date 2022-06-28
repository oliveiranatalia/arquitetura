package br.com.zup.movieflix.register.repository

import br.com.zup.movieflix.register.model.RegisterModel

class RegisterRepository {

    fun verify(model: RegisterModel): RegisterModel? {
        return when {
            model.userName.isNotEmpty() &&
                model.email.isNotEmpty() &&
                    model.password.isNotEmpty() -> RegisterModel(model.userName,model.email,model.password)
            else -> null
        }
    }
}