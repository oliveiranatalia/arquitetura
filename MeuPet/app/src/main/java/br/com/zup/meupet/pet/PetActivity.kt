package br.com.zup.meupet.pet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.meupet.databinding.ActivityPetBinding

class PetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPetBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}