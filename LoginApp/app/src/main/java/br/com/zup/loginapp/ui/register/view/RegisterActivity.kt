package br.com.zup.loginapp.ui.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.zup.loginapp.constants.USER
import br.com.zup.loginapp.databinding.ActivityRegisterBinding
import br.com.zup.loginapp.domain.model.User
import br.com.zup.loginapp.ui.home.view.MainActivity
import br.com.zup.loginapp.ui.register.viewmodel.RegisterViewModel
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observer()
        supportActionBar?.hide()
        binding.btRegister.setOnClickListener{
            register()
        }
    }
    private fun register(){
        val user = getData()
        viewModel.dataValidate(user)
    }
    private fun getData(): User {
        val user = User(
            binding.etEmail.text.toString(),binding.etPassword.text.toString()
        )
        return user
    }
    private fun observer(){
        viewModel.register.observe(this){ goToHome(it) }
        viewModel.error.observe(this){
            Snackbar.make(binding.root,it,Snackbar.LENGTH_SHORT).show()
        }
    }
    private fun goToHome(user:User){
        startActivity(Intent(this, MainActivity::class.java).apply { putExtra(USER,user) })
    }
}