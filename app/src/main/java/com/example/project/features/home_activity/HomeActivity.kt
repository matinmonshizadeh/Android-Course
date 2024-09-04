package com.example.project.features.home_activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.project.features.home_activity.presentation.ui.adapter.GenreAdapter
import com.example.project.features.home_activity.presentation.ui.adapter.MovieAdapter
import com.example.project.features.home_activity.presentation.ui.adapter.SliderAdapter
import com.example.project.features.home_activity.presentation.viewmodel.HomeViewModel
import com.example.project.features.home_activity.presentation.viewmodel.HomeViewModelFactory
import com.example.project.R
import com.example.project.databinding.ActivityHomeBinding
import com.example.project.features.favorite_activity.FavoriteActivity
import com.example.project.features.search_activity.SearchActivity


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        initialViewModel()
        configureViewModel()
        callAPI()
    }

    private fun initialBinding() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initialViewModel() {
        homeViewModel = ViewModelProvider(this, HomeViewModelFactory())[HomeViewModel::class.java]
    }

    private fun configureViewModel() {
        homeViewModel.genres.observe(this) { genres ->
            val genreAdapter = GenreAdapter(genres.data)
            binding.genreRecyclerView.adapter = genreAdapter
            binding.genreRecyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        }

        homeViewModel.movies.observe(this) { movies ->
            val listMovies = movies.data
            val movieAdapter = MovieAdapter(listMovies)
            val sliderAdapter = SliderAdapter(listMovies)

            binding.sliderRecyclerView.adapter = sliderAdapter
            binding.sliderRecyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

            binding.moviesRecyclerView.adapter = movieAdapter
            binding.moviesRecyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }

        binding.bottomNavigation.selectedItemId = R.id.home_page

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search_page -> {
                    val intent = Intent(this@HomeActivity, SearchActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.favorite_page -> {
                    val intent = Intent(this@HomeActivity, FavoriteActivity::class.java)
                    startActivity(intent)
                    true

                }
                else -> false
            }
        }

    }

    private fun callAPI() {
        CoroutineScope(Dispatchers.Main).launch {
            homeViewModel.getAllGenres()
            homeViewModel.getAllMoviesBasedOnGenreId(1)
        }
    }

}