package br.com.zup.recursoshumanos.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.recursoshumanos.HORA
import br.com.zup.recursoshumanos.KEY
import br.com.zup.recursoshumanos.SAL
import br.com.zup.recursoshumanos.VAL
import br.com.zup.recursoshumanos.databinding.FragmentDetailBinding
import br.com.zup.recursoshumanos.data.datasource.local.model.Employee

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var objeto:Employee

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showInfo()
    }
    private fun getInfo(){
        val func = arguments?.getParcelable<Employee>(KEY)
        func?.let {objeto = it}
    }
    private fun calculo(): Double {
        getInfo()
        val valor = objeto.getValor()
        val horas = objeto.getHoras()
        return horas * valor
    }
    private fun showInfo(){
        getInfo()
        val hora = "$HORA ${objeto.getHoras()}h"
        val valor = "$VAL ${objeto.getValor()}"
        val salario = "$SAL ${calculo()}"
        binding.tvNomeFunc.text = objeto.getNome()
        binding.tvHorasFunc.text = hora
        binding.tvValorHora.text = valor
        binding.tvResultado.text = salario
    }
}