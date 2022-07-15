package br.com.zup.loginapp.ui.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.loginapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}