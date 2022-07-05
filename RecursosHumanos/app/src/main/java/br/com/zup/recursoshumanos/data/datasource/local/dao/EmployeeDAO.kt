package br.com.zup.recursoshumanos.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.recursoshumanos.domain.model.Employee

@Dao
interface EmployeeDAO {

    @Query("SELECT * FROM employee ORDER BY name ASC")
    fun getList():List<Employee>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEmployee(employee: Employee)
}