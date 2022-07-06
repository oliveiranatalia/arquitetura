package br.com.zup.recursoshumanos.ui.register.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.recursoshumanos.ERROR_INSERT
import br.com.zup.recursoshumanos.REQUIRED
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.domain.usecase.EmployeeUseCase
import br.com.zup.recursoshumanos.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel(application: Application):AndroidViewModel(application) {
    private val employeeUseCase = EmployeeUseCase(application)
    val addEmployeeState = MutableLiveData<ViewState<Employee>>()

    private fun insertEmployee(employee: Employee){
        viewModelScope.launch {
            try{
                val response = withContext(Dispatchers.IO) {
                    employeeUseCase.insertEmployee(employee)
                }
                addEmployeeState.value = response
            }catch(e: Exception) {
                addEmployeeState.value =
                ViewState.Error(Throwable(ERROR_INSERT))
            }
        }
    }

    fun employeeVerification(name:String,hours:String,value:String){
        if(name.isNotEmpty() &&
            hours.isNotEmpty() &&
            value.isNotEmpty()
        ){
            insertEmployee(
                Employee(name, hours.toInt(), value.toDouble())
            )
        }else{
            addEmployeeState.value = ViewState.Error(Throwable(REQUIRED))
        }
    }
}