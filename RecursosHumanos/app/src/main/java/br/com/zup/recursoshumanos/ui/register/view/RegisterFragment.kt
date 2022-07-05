package br.com.zup.recursoshumanos.ui.register.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.zup.recursoshumanos.*
import br.com.zup.recursoshumanos.databinding.FragmentCadastroBinding
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.ui.employeelist.view.EmployeeListActivity
import br.com.zup.recursoshumanos.ui.register.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {
    private lateinit var binding:FragmentCadastroBinding
    private lateinit var name: String
    private lateinit var hours:String
    private lateinit var value:String
    private var list = arrayListOf<Employee>()
    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bvCalculate.setOnClickListener{
            insertEmployee()
        }

        binding.bvEmployeeList.setOnClickListener{
            goToList(this.list)
        }
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

        return if(name.isNotEmpty() || name.isNotBlank() && hours.isNotEmpty() || hours.isNotBlank() && value.isNotEmpty() || value.isNotBlank()) {
            clear()
            Employee(name, hours.toInt(), value.toDouble())
        }else{
            binding.etEmployeeName.error = REQUIRED
            binding.etHourWorked.error = REQUIRED
            binding.etHourlyRate.error = REQUIRED
            null
        }
    }
    private fun clear(){
        binding.etEmployeeName.text.clear()
        binding.etHourWorked.text.clear()
        binding.etHourlyRate.text.clear()
    }
    private fun goToList(list:ArrayList<Employee>){
        val intent = Intent(context, EmployeeListActivity::class.java).apply{
            putParcelableArrayListExtra(EMPLOYEE, list)
        }
        startActivity(intent)
        clear()
    }
}