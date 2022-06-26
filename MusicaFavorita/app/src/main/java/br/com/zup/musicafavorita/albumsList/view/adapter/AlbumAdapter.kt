package br.com.zup.musicafavorita.albumsList.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.musicafavorita.databinding.AlbumItemBinding
import br.com.zup.musicafavorita.model.Album

class AlbumAdapter(private var albumsList:MutableList<Album>, private var click: (album:Album) -> Unit
):RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    class ViewHolder(val binding: AlbumItemBinding):RecyclerView.ViewHolder(binding.root){
        fun showList(album:Album){
            binding.ivItem.setImageResource(album.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albumsList[position]
        holder.showList(album)
        holder.binding.cvItem.setOnClickListener{
            click(album)
        }
    }

    override fun getItemCount() = albumsList.size

}