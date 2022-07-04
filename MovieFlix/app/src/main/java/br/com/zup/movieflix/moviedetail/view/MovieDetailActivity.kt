package br.com.zup.movieflix.moviedetail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.KEY_MOVIE
import br.com.zup.movieflix.databinding.ActivityMovieDetailBinding
import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.viewmodel.MovieDetailViewModel

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMovieDetailBinding
    private val viewModel : MovieDetailViewModel by lazy {
        ViewModelProvider(this)[MovieDetailViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observable()
        getPassedData()
    }
    private fun getPassedData(){
        val movie = intent.getParcelableExtra<Movie>(KEY_MOVIE)
        movie?.let { viewModel.getMovieWithDirector(it) }
    }
    private fun observable(){
        viewModel.response.observe(this){
            binding.imageView.setImageResource(it.movie.image)
            binding.tvMovieTitle.text = it.movie.title.toString()
            binding.tvMovieSinopse.text = it.movie.sinopse.toString()
            binding.tvDirectorName.text = it.director.name.toString()
            binding.tvDirectorInfo.text = it.director.info.toString()
        }
    }
}