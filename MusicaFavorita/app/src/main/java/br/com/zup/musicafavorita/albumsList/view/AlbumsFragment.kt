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