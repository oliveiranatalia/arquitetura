package br.com.zup.loginapp.ui.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import br.com.zup.loginapp.R
import br.com.zup.loginapp.databinding.ActivityMainBinding
import br.com.zup.loginapp.ui.home.viewmodel.MainViewModel
import br.com.zup.loginapp.ui.login.view.LoginActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showUserEmail()

        supportActionBar?.hide()
    }
    private fun showUserEmail(){
        val email = viewModel.getEmail()
        val text = "Olá, "
        binding.tvUserEmail.text = text + email
    }
    private fun goToLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                viewModel.logout()
                this.finish()
                goToLogin()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}