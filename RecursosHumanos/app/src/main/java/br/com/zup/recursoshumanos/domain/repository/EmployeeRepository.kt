package br.com.zup.recursoshumanos.domain.repository

import br.com.zup.recursoshumanos.data.datasource.local.dao.EmployeeDAO
import br.com.zup.recursoshumanos.domain.model.Employee

class EmployeeRepository(private val employeeDAO: EmployeeDAO) {

    suspend fun getEmployeeList():List<Employee> = employeeDAO.getList()

    suspend fun insertEmployee(employee: Employee){
        employeeDAO.insertEmployee(employee)
    }
}