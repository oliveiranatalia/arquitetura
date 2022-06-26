package br.com.zup.musicafavorita.albumDetails.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import br.com.zup.musicafavorita.FAV
import br.com.zup.musicafavorita.KEY
import br.com.zup.musicafavorita.R
import br.com.zup.musicafavorita.databinding.ActivityAlbumDetailsBinding
import br.com.zup.musicafavorita.model.Album

class AlbumDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlbumDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAlbum()
        appBar()

        binding.ivIcone.setOnClickListener{
            Toast.makeText(this, FAV, Toast.LENGTH_LONG).show()
        }
    }
    private fun appBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.app_name)
    }
    private fun getAlbum(){
        val album = intent.getParcelableExtra<Album>(KEY)
        if(album != null) {
            binding.ivAlbumDetail.setImageResource(album.getImage())
            binding.tvNomeAlbum.text = album.getName()
            binding.tvDescAlbum.text = album.getDesc()
            binding.tvInfoAlbum.text = album.getInfo()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}