package br.com.zup.recursoshumanos.domain.usecase

import android.app.Application
import br.com.zup.recursoshumanos.ERROR_INSERT
import br.com.zup.recursoshumanos.ERROR_LIST
import br.com.zup.recursoshumanos.data.datasource.local.EmployeeDatabase
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.domain.repository.EmployeeRepository
import br.com.zup.recursoshumanos.ui.viewstate.ViewState

class EmployeeUseCase(application: Application){
    private val employeeDAO = EmployeeDatabase.getDatabase(application).employeeDao()
    private val employeeRepository = EmployeeRepository(employeeDAO)

    fun getEmployeeList():ViewState<List<Employee>> {
        return try {
            val list = employeeRepository.getEmployeeList()
            ViewState.Success(list)
        }catch (e: Exception) {
            ViewState.Error(Exception(ERROR_LIST))
        }
    }

    fun insertEmployee(employee: Employee):ViewState<Employee> {
        return try {
            employeeRepository.insertEmployee(employee)
            ViewState.Success(employee)
        } catch (e: Exception) {
            ViewState.Error(Exception(ERROR_INSERT))
        }
    }
}