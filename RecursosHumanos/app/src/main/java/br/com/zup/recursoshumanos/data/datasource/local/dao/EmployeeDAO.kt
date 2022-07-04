package br.com.zup.recursoshumanos.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import br.com.zup.recursoshumanos.data.datasource.local.model.Employee

@Dao
interface EmployeeDAO {
    @Query("SELECT * FROM employee ORDER BY name ASC")
    fun getAllEmployees():List<Employee>

    @Query("SELECT * FROM employee WHERE name= :name")
    fun getEmployeeName(name:String):Employee

}