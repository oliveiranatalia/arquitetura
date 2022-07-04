package br.com.zup.recursoshumanos.fragments

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
import br.com.zup.recursoshumanos.model.Funcionario

class CadastroFragment : Fragment() {
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
        binding.botao.setOnClickListener{
            sendInfo()
        }
    }
    private fun getInfo(){
        this.nome = binding.etNome.text.toString()
        this.horas = binding.etHoras.text.toString()
        this.valor = binding.etValor.text.toString()
    }
    private fun sendInfo(){
        val func = checkInfo()
        if(func != null){
            val bundle = bundleOf(KEY to func)
            NavHostFragment.findNavController(this).navigate(R.id.action_cadastroFragment_to_informacoesFragment,bundle)
        }
    }
    private fun checkInfo():Funcionario?{
        getInfo()
        return if(nome.isNotEmpty() || nome.isNotBlank() && horas.isNotEmpty() || horas.isNotBlank() && valor.isNotEmpty() || valor.isNotBlank()) {
            clear()
            Funcionario(nome, horas.toInt(), valor.toDouble())
        }else{
            binding.etNome.error = ERROR
            binding.etHoras.error = ERROR
            binding.etValor.error = ERROR
            null
        }
    }
    private fun clear(){
        binding.etNome.text.clear()
        binding.etValor.text.clear()
        binding.etHoras.text.clear()
    }
}