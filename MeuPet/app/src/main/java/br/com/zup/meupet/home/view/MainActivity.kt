package br.com.zup.meupet.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.zup.meupet.R
import br.com.zup.meupet.REQUIRED
import br.com.zup.meupet.databinding.ActivityMainBinding
import br.com.zup.meupet.home.model.MainModel
import br.com.zup.meupet.home.viewmodel.MainViewModel
import br.com.zup.meupet.pet.PetActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        viewModel.getDataSaved()

        viewModel.savedData.observe(this){
            binding.etName.setText(it.name)
        }
        viewModel.savedDataFlag.observe(this){
            binding.swSaveData.isChecked = it
        }
        binding.btSaveName.setOnClickListener{
            registration()
        }
    }
    fun registration(){
        val petName = binding.etName.text.toString()
        if(petName.isEmpty() || petName.isBlank()){
            binding.etName.error = REQUIRED
        }else{
            val pet = MainModel(petName)
            viewModel.authentication(pet, binding.swSaveData.isChecked)
            startActivity(Intent(this, PetActivity::class.java))
        }
    }
}