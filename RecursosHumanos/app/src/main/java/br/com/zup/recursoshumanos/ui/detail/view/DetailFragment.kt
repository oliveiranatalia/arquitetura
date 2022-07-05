package br.com.zup.recursoshumanos.ui.detail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.recursoshumanos.*
import br.com.zup.recursoshumanos.databinding.FragmentDetailBinding
import br.com.zup.recursoshumanos.domain.model.Employee

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var hours:String
    private lateinit var value:String
    private lateinit var salary:String
    private lateinit var name:String


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
    private fun getData(){
        val employee = arguments?.getParcelable<Employee>(EMPLOYEE)
        if(employee!= null){
            this.name = employee.name
            this.value = employee.value.toString()
            this.hours = employee.hours.toString()
            val result = hours.toInt() * value.toDouble()
            this.salary = result.toString()
        }
    }
    private fun showInfo(){
        getData()
        binding.tvNomeFunc.text = this.name
        binding.tvHorasFunc.text = "$HOUR ${this.hours}h"
        binding.tvValorHora.text = "$VAL ${this.value}"
        binding.tvResultado.text = "$SAL ${this.salary}"
    }
}