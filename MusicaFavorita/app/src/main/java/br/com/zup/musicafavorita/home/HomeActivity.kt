package br.com.zup.musicafavorita.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.musicafavorita.databinding.ActivityHomeBinding
import br.com.zup.musicafavorita.viewPager.InfoActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHome.setOnClickListener{
            startActivity(Intent(this, InfoActivity::class.java))
        }
    }
}