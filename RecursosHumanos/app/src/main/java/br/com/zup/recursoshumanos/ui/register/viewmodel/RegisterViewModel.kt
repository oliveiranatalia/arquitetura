package br.com.zup.recursoshumanos.ui.register.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.domain.usecase.EmployeeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel(application: Application):AndroidViewModel(application) {
    private val employeeUseCase = EmployeeUseCase(application)

    private fun insertEmployee(employee: Employee){
        viewModelScope.launch {
            try{
                val response = withContext(Dispatchers.IO){
                    employeeUseCase.insertEmployee(employee)
                }
            }catch(e: Exception) {
                Log.e("Error", "------> ${e.message}")
            }
        }
    }

    fun employeeVerification(name:String,hours:String,value:String){
            insertEmployee(Employee(name, hours.toInt(), value.toDouble()))
    }
}