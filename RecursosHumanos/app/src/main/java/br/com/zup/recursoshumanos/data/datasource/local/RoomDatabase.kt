package br.com.zup.recursoshumanos.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.recursoshumanos.data.datasource.local.dao.EmployeeDAO
import br.com.zup.recursoshumanos.domain.model.Employee

@Database(entities = [Employee::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): EmployeeDAO

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "filme_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}