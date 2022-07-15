package br.com.zup.loginapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.loginapp.databinding.ActivitySplashBinding
import br.com.zup.loginapp.ui.home.view.MainActivity
import br.com.zup.loginapp.ui.login.view.LoginActivity
import java.util.*

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        timer.schedule(object:TimerTask(){
            override fun run() {
                jump()
            }
        }, 3000)
    }
    private fun jump(){
        timer.cancel()
        startActivity(Intent(this, LoginActivity::class.java))
        this.finish()
    }
}