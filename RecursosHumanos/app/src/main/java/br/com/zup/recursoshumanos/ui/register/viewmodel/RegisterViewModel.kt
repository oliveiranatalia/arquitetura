package br.com.zup.recursoshumanos.ui.register.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.domain.usecase.EmployeeUseCase

class RegisterViewModel(application: Application):AndroidViewModel(application) {
    private val employeeUseCase = EmployeeUseCase(application)
    private val _response: MutableLiveData<List<Employee>> = MutableLiveData()
    val response: LiveData<List<Employee>> = _response

    //suspend fun getEmployeeList(){
    //    try{
    //        _response.value = employeeUseCase.getEmployeeList()
    //    }catch(e: Exception){
    //        Log.i("Error","${e.message}")
    //    }
    //}
}