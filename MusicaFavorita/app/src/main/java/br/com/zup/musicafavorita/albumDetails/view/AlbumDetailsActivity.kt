package br.com.zup.musicafavorita.albumDetails.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import br.com.zup.musicafavorita.FAV
import br.com.zup.musicafavorita.R
import br.com.zup.musicafavorita.databinding.ActivityAlbumDetailsBinding

class AlbumDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlbumDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    //getAlbum()
        appBar()

        binding.ivIcon.setOnClickListener{
            Toast.makeText(this, FAV, Toast.LENGTH_LONG).show()
        }
    }
    private fun appBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.app_name)
    }
    //private fun getAlbum(){
    //    //val album = intent.getExtra<Album>(ALBUM_KEY)
    //    if(al//bum != null) {
    //        binding.ivAlbumImage.setImageResource(album.getImage())
    //        binding.tvAlbumTitle.text = album.getName()
    //        binding.tvAlbumDescription.text = album.getDesc()
    //        binding.tvAlbumInformations.text = album.getInfo()
    //   }
    //}
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}