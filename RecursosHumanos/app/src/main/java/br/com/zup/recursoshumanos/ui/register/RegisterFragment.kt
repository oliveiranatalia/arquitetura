package br.com.zup.recursoshumanos.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.recursoshumanos.ERROR
import br.com.zup.recursoshumanos.KEY
import br.com.zup.recursoshumanos.R
import br.com.zup.recursoshumanos.databinding.FragmentCadastroBinding
import br.com.zup.recursoshumanos.ui.model.Employee

class RegisterFragment : Fragment() {
    private lateinit var binding:FragmentCadastroBinding
    private lateinit var nome:String
    private lateinit var horas:String
    private lateinit var valor:String

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
            sendInfo()
        }
    }
    private fun getInfo(){
        this.nome = binding.etEmployeeName.text.toString()
        this.horas = binding.etHourWorked.text.toString()
        this.valor = binding.etHourlyRate.text.toString()
    }
    private fun sendInfo(){
        val func = checkInfo()
        if(func != null){
            val bundle = bundleOf(KEY to func)
            NavHostFragment.findNavController(this).navigate(R.id.action_cadastroFragment_to_informacoesFragment,bundle)
        }
    }
    private fun checkInfo():Employee?{
        getInfo()
        return if(nome.isNotEmpty() || nome.isNotBlank() && horas.isNotEmpty() || horas.isNotBlank() && valor.isNotEmpty() || valor.isNotBlank()) {
            clear()
            Employee(nome, horas.toInt(), valor.toDouble())
        }else{
            binding.etEmployeeName.error = ERROR
            binding.etHourWorked.error = ERROR
            binding.etHourlyRate.error = ERROR
            null
        }
    }
    private fun clear(){
        binding.etEmployeeName.text.clear()
        binding.etHourWorked.text.clear()
        binding.etHourlyRate.text.clear()
    }
}