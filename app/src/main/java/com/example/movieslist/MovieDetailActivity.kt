package com.example.movieslist

import Movie
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.movieslist.model.Movies

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_URL = "url"

        fun newIntent(context: Context, movie: Movie): Intent {
            val detailIntent = Intent(context, MovieDetailActivity::class.java)

            detailIntent.putExtra(EXTRA_TITLE, movie.title)
            detailIntent.putExtra(EXTRA_URL, movie.instructionUrl)

            return detailIntent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val title = intent.extras?.getString(EXTRA_TITLE)
        val url = intent.extras?.getString(EXTRA_URL)
        setTitle(title)
        webView = findViewById(R.id.detail_web_view)
        url?.let { webView.loadUrl(it) }
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

    }
}