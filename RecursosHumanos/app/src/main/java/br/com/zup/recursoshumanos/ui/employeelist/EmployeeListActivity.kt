package br.com.zup.recursoshumanos.ui.employeelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.recursoshumanos.databinding.ActivityEmployeeListBinding

class EmployeeListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmployeeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeeListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}