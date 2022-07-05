package br.com.zup.recursoshumanos.domain.usecase

import android.app.Application
import androidx.constraintlayout.motion.utils.ViewState
import br.com.zup.recursoshumanos.ERROR_INSERT
import br.com.zup.recursoshumanos.ERROR_LIST
import br.com.zup.recursoshumanos.data.datasource.local.EmployeeDatabase
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.domain.repository.EmployeeRepository

class EmployeeUseCase(application: Application) {
    private val employeeDao = EmployeeDatabase.getDatabase(application).employeeDao()
    private val employeeRepository = EmployeeRepository(employeeDao)

   //suspend fun getEmployeeList(): ViewState<List<Employee>> {
   //    return try {
   //        val list = employeeRepository.getEmployeeList()
   //        ViewState.Success(list)
   //    }catch (ex:Exception){
   //        ViewState.Error(Exception(ERROR_LIST))
   //    }
   //}
   //suspend fun insertEmployee(employee: Employee):ViewState<Employee>{
   //    return try{
   //        employeeRepository.insertEmployee(employee)
   //        ViewState.Success(employee)
   //    }catch (ex:Exception){
   //        ViewState.Error(Exception(ERROR_INSERT))
   //    }
   //}
}