package br.com.zup.movieflix.moviedetail.datasource

import br.com.zup.movieflix.R
import br.com.zup.movieflix.moviedetail.model.DirectorModel

class DirectorLocalDataSource {
    val directorList = mutableListOf(
        DirectorModel(
            R.string.tarantino,
            R.string.tarantino_info
        ),
        DirectorModel(
            R.string.scorsese,
            R.string.scorsese_info
        )
    )
}