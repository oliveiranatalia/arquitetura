package br.com.zup.recursoshumanos.ui.register.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.recursoshumanos.*
import br.com.zup.recursoshumanos.databinding.FragmentCadastroBinding
import br.com.zup.recursoshumanos.domain.model.Employee

class RegisterFragment : Fragment() {
    private lateinit var binding:FragmentCadastroBinding
    private lateinit var name: String
    private lateinit var hours:String
    private lateinit var value:String
    private var list = arrayListOf<Employee>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRecover()

        binding.bvCalculate.setOnClickListener{
            insertEmployee()
        }

        binding.bvEmployeeList.setOnClickListener{
            goToList(list)
        }
    }
    private fun listRecover(){
        val employeeList = arguments?.getParcelableArrayList<Employee>(EMPLOYEE)
        employeeList?.let { list = it }
    }
    private fun insertEmployee() {
        val employee = checkInfo()
        if(employee != null){
            this.list.add(employee)
            Toast.makeText(context, REGISTRED,Toast.LENGTH_LONG).show()
        }
    }
    private fun checkInfo():Employee?{
        this.name = binding.etEmployeeName.text.toString()
        this.hours = binding.etHourWorked.text.toString()
        this.value = binding.etHourlyRate.text.toString()

        if(name.isNotEmpty() && hours.isNotEmpty() && value.isNotEmpty()) {
            clear()
            return Employee(name, hours.toInt(), value.toDouble())
        }else{
            binding.etEmployeeName.error = REQUIRED
            binding.etHourWorked.error = REQUIRED
            binding.etHourlyRate.error = REQUIRED
            return null
        }
    }
    private fun clear(){
        binding.etEmployeeName.text.clear()
        binding.etHourWorked.text.clear()
        binding.etHourlyRate.text.clear()
    }
    private fun goToList(list:ArrayList<Employee>){
        val bundle = bundleOf(EMPLOYEE_LIST to list)
        NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment_to_employeeListFragment,bundle)
    }
}