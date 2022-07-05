package br.com.zup.recursoshumanos.ui.employeelist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.recursoshumanos.EMPLOYEE
import br.com.zup.recursoshumanos.databinding.ActivityEmployeeListBinding
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.ui.detail.view.DetailFragment
import br.com.zup.recursoshumanos.ui.employeelist.adapter.EmployeeAdapter
import br.com.zup.recursoshumanos.ui.employeelist.viewmodel.EmployeeListViewModel

class EmployeeListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmployeeListBinding
    private val viewModel: EmployeeListViewModel by lazy {
        ViewModelProvider(this)[EmployeeListViewModel::class.java]}
    private val adapter: EmployeeAdapter by lazy {
        EmployeeAdapter(arrayListOf(),this::goToDetail)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeeListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showRecyclerView()
        //viewModel.getEmployeeList()
    }
    private fun showRecyclerView(){
        binding.rvEmployeeList.adapter = adapter
        binding.rvEmployeeList.layoutManager = LinearLayoutManager(this)
    }

    private fun goToDetail(employee: Employee){
        val intent = Intent(this, DetailFragment::class.java).apply {
            putExtra(EMPLOYEE,employee)
        }
        startActivity(intent)
    }
}