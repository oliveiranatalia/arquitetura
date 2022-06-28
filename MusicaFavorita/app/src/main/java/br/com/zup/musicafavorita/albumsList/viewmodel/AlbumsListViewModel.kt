package br.com.zup.musicafavorita.albumsList.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.musicafavorita.albumsList.repository.AlbumListRepository
import br.com.zup.musicafavorita.model.Album

class AlbumsListViewModel() :ViewModel() {
    private val repository = AlbumListRepository()
    private val _response: MutableLiveData<List<Album>> = MutableLiveData()
    val response:LiveData<List<Album>> = _response

    fun getAlbumsList(){
        try{
            _response.value = repository.getAlbum()
        }catch(e: Exception){
            Log.i("Error","${e.message}")
        }
    }
}