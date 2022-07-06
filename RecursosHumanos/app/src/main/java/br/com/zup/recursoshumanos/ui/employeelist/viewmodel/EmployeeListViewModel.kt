package br.com.zup.recursoshumanos.ui.employeelist.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.recursoshumanos.ERROR_LIST
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.domain.usecase.EmployeeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EmployeeListViewModel(application: Application):AndroidViewModel(application) {
    private val employeeUseCase = EmployeeUseCase(application)
    val employeeList = MutableLiveData<List<Employee>>()
    val exception = ERROR_LIST

    fun getList(){
        viewModelScope.launch {
            try{
                val response = withContext(Dispatchers.IO){
                    employeeUseCase.getEmployeeList()
                }
                employeeList.value = response
            }catch(e: Exception) {
                exception
            }
        }
    }
}