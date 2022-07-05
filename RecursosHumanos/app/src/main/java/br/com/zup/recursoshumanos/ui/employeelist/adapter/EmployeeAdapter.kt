package br.com.zup.recursoshumanos.ui.employeelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.recursoshumanos.databinding.EmployeeItemBinding
import br.com.zup.recursoshumanos.domain.model.Employee

class EmployeeAdapter(
    private var list:MutableList<Employee>,
    private val click:(emplote:Employee) -> Unit
): RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    class ViewHolder(val binding: EmployeeItemBinding):RecyclerView.ViewHolder(binding.root){
        fun showList(employee: Employee){
            binding.tvNameItem.text = employee.name
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EmployeeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = list[position]
        holder.showList(employee)
        holder.binding.cvItem.setOnClickListener{
            click(employee)
        }
    }
    fun updateList(newList:ArrayList<Employee>){
        if(list.size ==0 || list == newList){
            list = newList
        }else{
            list.addAll(newList)
        }
        notifyDataSetChanged()
    }
    override fun getItemCount() = list.size
}