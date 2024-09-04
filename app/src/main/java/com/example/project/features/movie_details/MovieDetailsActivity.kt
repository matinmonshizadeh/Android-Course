package com.example.project.features.movie_details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.project.databinding.ActivityMovieDetailsBinding
import com.example.project.features.movie_details.presentation.ui.adapter.ImageAdapter
import com.example.project.features.movie_details.presentation.viewmodel.DetailsViewModel
import com.example.project.features.movie_details.presentation.viewmodel.MovieDetailsViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding
    private lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        initialViewModel()
        configViewModel()
        callApi()
    }

    private fun initialBinding() {
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initialViewModel() {
        viewModel =
            ViewModelProvider(this, MovieDetailsViewModelFactory())[DetailsViewModel::class.java]
    }

    private fun configViewModel() {
        viewModel.movieDetails.observe(this) { movieDetails ->
            val imageAdapter = ImageAdapter(movieDetails.data.movieDetailsImages)

            Glide.with(binding.movieDetailsPoster.context)
                .load(movieDetails.data.movieDetailsPoster)
                .into(binding.movieDetailsPoster)
            Glide.with(binding.movieDetailsBackgroundPoster.context)
                .load(movieDetails.data.movieDetailsPoster)
                .into(binding.movieDetailsBackgroundPoster)
            binding.movieDetailsTitle.text = movieDetails.data.movieDetailsTitle
            binding.movieDetailsRating.text = movieDetails.data.movieDetailsImdbRating
            binding.movieDetailsDuration.text = movieDetails.data.movieDetailsRuntime
            binding.movieDetailsReleaseDate.text = movieDetails.data.movieDetailsReleased
            binding.movieDetailsSummary.text = movieDetails.data.movieDetailsSummary
            binding.movieDetailsActors.text = movieDetails.data.movieDetailsActors

            binding.movieDetailsImagesRecyclerView.adapter = imageAdapter
            binding.movieDetailsImagesRecyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.movieDetailsBackButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun callApi() {
        CoroutineScope(Dispatchers.Main).launch {
            val movieId = intent.getIntExtra("movieId", 1)
            viewModel.getMovieDetailsBasedOnId(movieId)
        }
    }
}