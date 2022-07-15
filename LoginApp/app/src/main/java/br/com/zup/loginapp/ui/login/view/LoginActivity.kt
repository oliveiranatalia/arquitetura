package br.com.zup.loginapp.ui.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.zup.loginapp.constants.USER
import br.com.zup.loginapp.databinding.ActivityLoginBinding
import br.com.zup.loginapp.domain.model.User
import br.com.zup.loginapp.ui.home.view.MainActivity
import br.com.zup.loginapp.ui.login.viewmodel.LoginViewModel
import br.com.zup.loginapp.ui.register.view.RegisterActivity
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observer()

        supportActionBar?.hide()

        binding.tvRegister.setOnClickListener{
            goToRegister()
        }
        binding.bvLogin.setOnClickListener{
            goToLogin()
        }
    }
    private fun goToLogin(){
        val user = getData()
        viewModel.validate(user)
    }
    private fun getData(): User {
        val user = User(binding.etEmail.text.toString(),binding.etPassword.text.toString())
        return user
    }
    private fun goToRegister(){
        startActivity(Intent(this, RegisterActivity::class.java))
    }
    private fun goToHome(user:User){
        startActivity(Intent(this,MainActivity::class.java).apply { putExtra(USER,user)})
    }
    private fun observer(){
        viewModel.login.observe(this){ goToHome(it)}

        viewModel.error.observe(this){
            Snackbar.make(binding.root,it,Snackbar.LENGTH_SHORT).show()}
    }
}