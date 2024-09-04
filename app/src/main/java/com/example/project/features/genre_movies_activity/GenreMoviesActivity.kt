package com.example.project.features.genre_movies_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.databinding.ActivityGenreMoviesBinding
import com.example.project.features.home_activity.presentation.ui.adapter.MovieAdapter
import com.example.project.features.home_activity.presentation.viewmodel.HomeViewModel
import com.example.project.features.home_activity.presentation.viewmodel.HomeViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class GenreMoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGenreMoviesBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        initialViewModel()
        configureViewModel()
        callAPI()
    }

    private fun initialBinding() {
        binding = ActivityGenreMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initialViewModel() {
        homeViewModel = ViewModelProvider(this, HomeViewModelFactory())[HomeViewModel::class.java]
    }

    private fun configureViewModel() {
        homeViewModel.movies.observe(this) { movies ->
            val listMovies = movies.data
            val movieAdapter = MovieAdapter(listMovies)

            binding.genreMoviesRecyclerView.adapter = movieAdapter
            binding.genreMoviesRecyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun callAPI() {
        CoroutineScope(Dispatchers.Main).launch {
            val genreId = intent.getIntExtra("genreId", 1)
            homeViewModel.getAllMoviesBasedOnGenreId(genreId)
        }
    }

}
