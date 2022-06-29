package br.com.zup.meupet.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.meupet.R
import br.com.zup.meupet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btSaveName.setOnClickListener{

        }
    }
}