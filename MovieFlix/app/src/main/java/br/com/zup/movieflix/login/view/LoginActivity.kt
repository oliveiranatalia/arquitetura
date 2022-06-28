package br.com.zup.movieflix.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.ERROR
import br.com.zup.movieflix.REQUIRED
import br.com.zup.movieflix.databinding.ActivityLoginBinding
import br.com.zup.movieflix.home.view.HomeActivity
import br.com.zup.movieflix.login.model.LoginModel
import br.com.zup.movieflix.login.viewmodel.LoginViewModel
import br.com.zup.movieflix.register.view.RegisterActivity


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getDataSaved()
        observers()

        binding.tvRegistro.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            binding.etUsername.text.clear()
            binding.etPassword.text.clear()
        }
        binding.bvLogin.setOnClickListener {
            authenticate()
        }

    }

    fun authenticate(){
        val user = binding.etUsername.text.toString()
        val password =  binding.etPassword.text.toString()

        when{
            user.isEmpty() && password.isEmpty() -> {
                binding.etUsername.error = REQUIRED
                binding.etPassword.error = REQUIRED
            } else -> {
            val login = LoginModel(user, password)
            viewModel.authentication(login, binding.swSaveData.isChecked)
            }
        }
    }

    fun observers(){
        viewModel.response.observe(this){
            if(it.accessAuth){
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(this, ERROR, Toast.LENGTH_LONG).show()
                binding.etUsername.text.clear()
                binding.etPassword.text.clear()
            }
        }
        viewModel.savedData.observe(this){
            binding.etUsername.setText(it.user)
            binding.etPassword.setText(it.password)
        }
        viewModel.savedDataFlag.observe(this){
            binding.swSaveData.isChecked = it
        }
    }
}