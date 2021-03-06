package br.com.zup.recursoshumanos.ui.employeelist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.recursoshumanos.EMPLOYEE
import br.com.zup.recursoshumanos.ERROR_LIST
import br.com.zup.recursoshumanos.R
import br.com.zup.recursoshumanos.databinding.FragmentEmployeeListBinding
import br.com.zup.recursoshumanos.domain.model.Employee
import br.com.zup.recursoshumanos.ui.employeelist.adapter.EmployeeAdapter
import br.com.zup.recursoshumanos.ui.employeelist.viewmodel.EmployeeListViewModel
import br.com.zup.recursoshumanos.ui.viewstate.ViewState

class EmployeeListFragment : Fragment() {
    private lateinit var binding: FragmentEmployeeListBinding
    private val adapter: EmployeeAdapter by lazy { EmployeeAdapter(arrayListOf(),::goToDetail) }
    private val viewModel: EmployeeListViewModel by lazy { ViewModelProvider(this)[EmployeeListViewModel::class.java]}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        showRecyclerView()
        observer()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getList()
    }
    private fun observer(){
        viewModel.employeeList.observe(this.viewLifecycleOwner){
            if(it is ViewState.Success){
                adapter.updateList(it.data)
            }else{
                binding.tvListTitle.text = ERROR_LIST
            }
        }
    }
    private fun showRecyclerView(){
        binding.rvEmployeeList.adapter = adapter
        binding.rvEmployeeList.layoutManager = LinearLayoutManager(context)
    }
    private fun goToDetail(employee: Employee){
        val bundle = bundleOf(EMPLOYEE to employee)
        NavHostFragment.findNavController(this).navigate(R.id.action_employeeListFragment_to_detailFragment,bundle)
    }
}