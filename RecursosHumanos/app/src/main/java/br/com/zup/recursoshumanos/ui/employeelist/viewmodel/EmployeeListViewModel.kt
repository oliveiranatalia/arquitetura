package br.com.zup.recursoshumanos.ui.employeelist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.recursoshumanos.ERROR_LIST
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.domain.usecase.EmployeeUseCase
import br.com.zup.recursoshumanos.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EmployeeListViewModel(application: Application):AndroidViewModel(application) {
    private val employeeUseCase = EmployeeUseCase(application)
    val employeeList = MutableLiveData<ViewState<List<Employee>>>()

    fun getList(){
        viewModelScope.launch {
            try{
                val response = withContext(Dispatchers.IO){
                    employeeUseCase.getEmployeeList()
                }
                employeeList.value = response
            }catch(e: Exception) {
                employeeList.value = ViewState.Error(Throwable(ERROR_LIST))
            }
        }
    }
}