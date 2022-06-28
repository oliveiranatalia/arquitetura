package br.com.zup.movieflix.register.repository

import br.com.zup.movieflix.register.model.RegisterModel

class RegisterRepository {
    fun validate(register: RegisterModel):RegisterModel {

        register.access = (register.userName == "" && register.email == "" && register.password == "")
        return register
    }
}