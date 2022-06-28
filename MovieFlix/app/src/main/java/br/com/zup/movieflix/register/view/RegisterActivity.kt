package br.com.zup.movieflix.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.zup.movieflix.const.RECORD
import br.com.zup.movieflix.const.REQUIRED
import br.com.zup.movieflix.databinding.ActivityRegisterBinding
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var viewModel = RegisterViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getUserInformations()
    }

    private fun getUserInformations(){
        val userName = binding.etUserNameRegister.text.toString()
        val email = binding.etEmailRegister.text.toString()
        val password = binding.etPasswordRegister.text.toString()
        val user = RegisterModel(userName,email,password)

        viewModel.authentication(user)
        validation(user)
    }
    private fun validation(user:RegisterModel?){
        if(user != null){
            binding.bvLogin.setOnClickListener{
                Toast.makeText(this, RECORD,Toast.LENGTH_LONG).show()
            clear()
            }
        }else{
            binding.etUserNameRegister.error = REQUIRED
            binding.etEmailRegister.error = REQUIRED
            binding.etPasswordRegister.error = REQUIRED
            binding.etConfirmPasswordRegister.error = REQUIRED
        }
    }
    private fun clear(){
        binding.etUserNameRegister.text.clear()
        binding.etEmailRegister.text.clear()
        binding.etPasswordRegister.text.clear()
        binding.etConfirmPasswordRegister.text.clear()
    }
}