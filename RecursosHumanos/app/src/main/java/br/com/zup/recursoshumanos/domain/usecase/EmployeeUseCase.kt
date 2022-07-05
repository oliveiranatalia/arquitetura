package br.com.zup.recursoshumanos.domain.usecase

import android.app.Application
import br.com.zup.recursoshumanos.data.datasource.local.EmployeeDatabase
import br.com.zup.recursoshumanos.domain.repository.EmployeeRepository

class EmployeeUseCase(application: Application) {
    private val employeeDao = EmployeeDatabase.getDatabase(application).employeeDao()
    private val employeeRepository = EmployeeRepository(employeeDao)
    }
}