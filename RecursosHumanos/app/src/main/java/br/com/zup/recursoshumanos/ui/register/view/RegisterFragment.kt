package br.com.zup.recursoshumanos.ui.register.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.recursoshumanos.*
import br.com.zup.recursoshumanos.databinding.FragmentRegisterBinding
import br.com.zup.recursoshumanos.ui.register.viewmodel.RegisterViewModel
import br.com.zup.recursoshumanos.ui.viewstate.ViewState

class RegisterFragment : Fragment() {
    private lateinit var binding:FragmentRegisterBinding
    private val viewModel: RegisterViewModel by lazy {ViewModelProvider(this)[RegisterViewModel::class.java]}

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
        viewModel.employeeVerification(
            binding.etEmployeeName.text.toString(),
            binding.etHourWorked.text.toString(),
            binding.etHourlyRate.text.toString()
        )
        observer()
    }

    private fun observer(){
        viewModel.addEmployeeState.observe(this.viewLifecycleOwner){
            if(it is ViewState.Success) {
                Toast.makeText(context, REGISTRED, Toast.LENGTH_LONG).show()
                clear()
            }else{
                binding.etEmployeeName.error = REQUIRED
                binding.etHourWorked.error = REQUIRED
                binding.etHourlyRate.error = REQUIRED
            }
        }
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