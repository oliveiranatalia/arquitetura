package br.com.zup.movieflix.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.DMATCH
import br.com.zup.movieflix.REQUIRED
import br.com.zup.movieflix.databinding.ActivityRegisterBinding
import br.com.zup.movieflix.login.view.LoginActivity
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by lazy{
        ViewModelProvider(this) [RegisterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registration()
        observers()

        binding.bvLogin.setOnClickListener{
            registration()
        }
    }

    fun registration (){
        val userName = binding.etUserNameRegister.text.toString()
        val email = binding.etEmailRegister.text.toString()
        val password = binding.etPasswordRegister.text.toString()
        val confirm = binding.etConfirmPasswordRegister.text.toString()

        when{
            userName.isEmpty() && email.isEmpty() && password.isEmpty() && confirm.isEmpty() -> {
                binding.etUserNameRegister.error = REQUIRED
                binding.etEmailRegister.error = REQUIRED
                binding.etPasswordRegister.error = REQUIRED
                binding.etConfirmPasswordRegister.error = REQUIRED
            }else ->
            if(confirm == password){

                val register = RegisterModel(userName, email, password)
                viewModel.validate(register)

                startActivity(Intent(this, LoginActivity::class.java))
            }else{
                binding.etConfirmPasswordRegister.error = DMATCH
            }
        }
    }

    fun observers(){
        viewModel.savedData.observe(this){
            binding.etUserNameRegister.setText(it.userName)
            binding.etEmailRegister.setText(it.email)
            binding.etPasswordRegister.setText(it.password)
        }
    }
}