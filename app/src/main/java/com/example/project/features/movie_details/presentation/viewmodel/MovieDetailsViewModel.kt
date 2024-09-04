package com.example.project.features.movie_details.presentation.viewmodel

import androidx.lifecycle.*
import com.example.project.features.movie_details.domain.data.model.movie_details.MovieDetailsResponse
import com.example.project.features.movie_details.domain.data.repository.MovieDetailsRepository
import com.example.project.shared_components.API
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: MovieDetailsRepository) : ViewModel() {
    private val _movieDetails = MutableLiveData<MovieDetailsResponse>()
    val movieDetails: LiveData<MovieDetailsResponse> get() = _movieDetails

    fun getMovieDetailsBasedOnId(movieId: Int) {
        viewModelScope.launch {
            val response = repository.getMovieDetailsBasedOnId(movieId)
            if (response.isSuccess) {
                response.onSuccess {
                    _movieDetails.postValue(it)
                }.onFailure {
                    //TODO
                }
            }
        }
    }

}

class MovieDetailsModule {
    companion object {
        val watchRepository: MovieDetailsRepository by lazy {
            MovieDetailsRepository(API.Companion.DetailsService)
        }
    }
}

class MovieDetailsViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(MovieDetailsModule.watchRepository) as T
        }
        throw java.lang.IllegalArgumentException("wrong dependency")
    }
}
