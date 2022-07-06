package br.com.zup.recursoshumanos.domain.usecase

import android.app.Application
import android.util.Log
import br.com.zup.recursoshumanos.data.datasource.local.EmployeeDatabase
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.domain.repository.EmployeeRepository

class EmployeeUseCase(application: Application){
    private val employeeDAO = EmployeeDatabase.getDatabase(application).employeeDao()
    private val employeeRepository = EmployeeRepository(employeeDAO)

    fun getEmployeeList(): List<Employee>? {
        try {
            return employeeRepository.getEmployeeList()
        } catch (e: Exception) {
            Log.e("Error", "------> ${e.message}")
            return null
        }
    }

    fun insertEmployee(employee: Employee) {
        try {
            employeeRepository.insertEmployee(employee)
        } catch (e: Exception) {
            Log.e("Error", "------> ${e.message}")
        }
    }
}