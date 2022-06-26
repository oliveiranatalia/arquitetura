package br.com.zup.musicafavorita.albumsList.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.musicafavorita.*
import br.com.zup.musicafavorita.databinding.FragmentAlbumsBinding
import br.com.zup.musicafavorita.model.Album
import br.com.zup.musicafavorita.albumDetails.view.AlbumDetailsActivity
import br.com.zup.musicafavorita.albumsList.view.adapter.AlbumAdapter

class AlbumsFragment : Fragment() {
    private lateinit var binding: FragmentAlbumsBinding
    private val albumAdapter: AlbumAdapter by lazy { AlbumAdapter(arrayListOf(), this::getDetails) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumsBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAlbumList()
    }
    private fun getAlbumList(){
        val albumList = mutableListOf<Album>()
        albumList.add(Album(R.drawable.album_um, ALBUM1, DESC1, INFO1))
        albumList.add(Album(R.drawable.algum_dois, ALBUM2, DESC2, INFO2))
        albumList.add(Album(R.drawable.album_tres, ALBUM3, DESC3, INFO3))
        albumList.add(Album(R.drawable.album_quatro,ALBUM4,DESC4, INFO4))
        albumList.add(Album(R.drawable.album_cinco, ALBUM5, DESC5, INFO5))
        albumList.add(Album(R.drawable.album_seis,ALBUM6, DESC6, INFO6))
        albumList.add(Album(R.drawable.album_sete, ALBUM7, DESC7, INFO7))
        albumList.add(Album(R.drawable.album_oito,ALBUM8,DESC8,INFO8))
        albumList.add(Album(R.drawable.album_nove,ALBUM9,DESC9,INFO9))
        albumList.add(Album(R.drawable.album_dez,ALBUM10,DESC10,INFO10))
        albumList.add(Album(R.drawable.album_onze,ALBUM11,DESC11,INFO11))
        albumList.add(Album(R.drawable.album_doze,ALBUM12,DESC12,INFO12))
        albumList.add(Album(R.drawable.album_treze,ALBUM13,DESC13,INFO13))
        albumAdapter.update(albumList)
        showRecyclerView()
    }
    private fun showRecyclerView(){
        binding.rvListaAlbum.adapter = albumAdapter
        binding.rvListaAlbum.layoutManager = GridLayoutManager(context,2)
    }
    private fun getDetails(album:Album){
        startActivity(Intent(context, AlbumDetailsActivity::class.java).putExtra(KEY,album))
    }
}