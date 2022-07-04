package br.com.zup.meupet.pet.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.meupet.databinding.ActivityPetBinding

class PetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}