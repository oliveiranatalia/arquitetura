package br.com.zup.recursoshumanos.ui.register.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.recursoshumanos.*
import br.com.zup.recursoshumanos.databinding.FragmentRegisterBinding
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.ui.register.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {
    private lateinit var binding:FragmentRegisterBinding
    private val viewModel: RegisterViewModel by lazy {ViewModelProvider(this)[RegisterViewModel::class.java]}
    private lateinit var name: String
    private lateinit var hours:String
    private lateinit var value:String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bvCalculate.setOnClickListener{
            insertEmployee()
        }

        binding.bvEmployeeList.setOnClickListener{
            goToList()
        }
        setHasOptionsMenu(true)
    }
    private fun insertEmployee() {
        getData()
        if(name.isNotEmpty() && hours.isNotEmpty() && value.isNotEmpty()) {
            Toast.makeText(context, REGISTRED,Toast.LENGTH_LONG).show()
            viewModel.employeeVerification(name, hours, value)
            clear()
        }else{
            binding.etEmployeeName.error = REQUIRED
            binding.etHourWorked.error = REQUIRED
            binding.etHourlyRate.error = REQUIRED
        }
    }

    private fun getData(){
        this.name = binding.etEmployeeName.text.toString()
        this.hours = binding.etHourWorked.text.toString()
        this.value = binding.etHourlyRate.text.toString()
    }
    private fun clear(){
        binding.etEmployeeName.text.clear()
        binding.etHourWorked.text.clear()
        binding.etHourlyRate.text.clear()
    }
    private fun goToList(){
        NavHostFragment.findNavController(this).navigate(R.id.action_registerFragment_to_employeeListFragment)
    }
}