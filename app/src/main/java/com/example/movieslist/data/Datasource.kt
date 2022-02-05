package com.example.movieslist.data

import com.example.movieslist.R
import com.example.movieslist.model.Movies

class Datasource {
    fun loadMovies(): List<Movies> {
        return listOf(
            Movies(R.string.movie1, R.drawable.dk),
            Movies(R.string.movie2, R.drawable.inc),
            Movies(R.string.movie3, R.drawable.dune),
            Movies(R.string.movie4, R.drawable.gf),
            Movies(R.string.movie5, R.drawable.tit),
            Movies(R.string.movie6,R.drawable.fc)
        )
    }
}