package com.example.movieslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.movie_list_view)

        val movieList = Movie.getMoviesFromFile("movies.json", this)

        val adapter = ItemAdapter(this, movieList)
        listView.adapter = adapter

        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedMovie = movieList[position]

            val detailIntent = MovieDetailActivity.newIntent(context, selectedMovie)

            startActivity(detailIntent)
        }
    }
}
