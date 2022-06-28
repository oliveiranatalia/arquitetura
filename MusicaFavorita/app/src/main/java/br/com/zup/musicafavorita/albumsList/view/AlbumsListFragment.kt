package br.com.zup.musicafavorita.albumsList.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.musicafavorita.ALBUM_KEY
import br.com.zup.musicafavorita.albumDetails.view.AlbumDetailsActivity
import br.com.zup.musicafavorita.model.Album
import br.com.zup.musicafavorita.albumsList.view.adapter.AlbumAdapter
import br.com.zup.musicafavorita.albumsList.viewmodel.AlbumsListViewModel
import br.com.zup.musicafavorita.databinding.FragmentAlbumslistBinding

class AlbumsListFragment : Fragment() {
    private lateinit var binding: FragmentAlbumslistBinding
    private val albumAdapter: AlbumAdapter by lazy { AlbumAdapter(arrayListOf(), this::getDetails) }
    private val viewModel: AlbumsListViewModel by lazy { ViewModelProvider(this)[AlbumsListViewModel::class.java]}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumslistBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAlbumList()
    }
    private fun getAlbumList(){
        viewModel.getAlbumsList()
        viewModel.response.observe(this.viewLifecycleOwner){
            albumAdapter.albumsList.addAll(it)
        }
        showRecyclerView()
    }
    private fun showRecyclerView(){
        binding.rvAlbumList.adapter = albumAdapter
        binding.rvAlbumList.layoutManager = GridLayoutManager(context,2)
    }
    private fun getDetails(album:Album){
        val intent = Intent(this.context, AlbumDetailsActivity::class.java).apply{
            putExtra(ALBUM_KEY, album)
        }
        startActivity(intent)
    }
}