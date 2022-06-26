package br.com.zup.musicafavorita.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.musicafavorita.databinding.ActivityBandBinding
import br.com.zup.musicafavorita.swipeViews.view.InfoActivity

class BandActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBandBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBandBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHome.setOnClickListener{
            startActivity(Intent(this, InfoActivity::class.java))
        }
    }
}