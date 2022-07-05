package br.com.zup.recursoshumanos.ui.employeelist.viewmodel

import android.app.Application
import androidx.constraintlayout.motion.utils.ViewState
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
   //val employeeListState = MutableLiveData<ViewState<List<Employee>>>()

   //fun getEmployeeList(){
   //    viewModelScope.launch {
   //        try{
   //            val response = withContext(Dispatchers.IO){
   //                employeeUseCase.getEmployeeList()
   //            }
   //            employeeListState.value = response
   //        }catch(e:Exception){
   //            employeeListState.value = ViewState.Error(Throwab//le(ERROR_LIST))
   //        }
   //    }
   //}
}