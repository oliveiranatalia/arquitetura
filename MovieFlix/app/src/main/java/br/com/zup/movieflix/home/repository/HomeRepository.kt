package br.com.zup.movieflix.home.repository

import br.com.zup.movieflix.*
import br.com.zup.movieflix.home.model.Movie

class HomeRepository {

    fun getListMovie(): List<Movie> {
        val listMovie = mutableListOf<Movie>()

        listMovie.add(Movie(
            R.string.pulpFiction,
            R.string.pulpFiction_sinopse,
            R.drawable.pulpfiction,
            R.string.tarantino
        ))
        listMovie.add(Movie(
            R.string.taxiDriver,
            R.string.taxiDriver_sinopse,
            R.drawable.taxidriver,
            R.string.scorsese
        ))
        listMovie.add(Movie(
            R.string.django,
            R.string.django_sinopse,
            R.drawable.jango,
            R.string.tarantino
        ))
        listMovie.add(Movie(
            R.string.goodFellas,
            R.string.goodFellas_sinopse,
            R.drawable.bonscompanheiros,
            R.string.scorsese
        ))
        listMovie.add(Movie(
            R.string.resevoirDogs,
            R.string.resevoirDogs_sinopse,
            R.drawable.reservoirdogs,
            R.string.tarantino
        ))
        listMovie.add(Movie(
            R.string.wolfWallstreet,
            R.string.wolfWallstreet_sinopse,
            R.drawable.wolfwallstreet,
            R.string.scorsese
        ))
        return listMovie
    }
}