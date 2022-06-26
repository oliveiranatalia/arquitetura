package br.com.zup.musicafavorita.launcher.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.musicafavorita.databinding.ActivityHomeBinding
import br.com.zup.musicafavorita.swipeViews.InfoActivity

class BandActivity : AppCompatActivity() {
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