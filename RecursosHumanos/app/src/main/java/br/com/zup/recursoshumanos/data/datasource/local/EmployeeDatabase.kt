package br.com.zup.recursoshumanos.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.recursoshumanos.data.datasource.local.dao.EmployeeDAO
import br.com.zup.recursoshumanos.domain.model.Employee

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract fun employeeDao(): EmployeeDAO

    companion object {
        @Volatile
        private var INSTANCE: EmployeeDatabase? = null

        fun getDatabase(context: Context): EmployeeDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EmployeeDatabase::class.java,
                    "filme_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}