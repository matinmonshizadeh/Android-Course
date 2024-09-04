package com.example.project.features.home_activity.presentation.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import com.example.project.features.home_activity.domain.data.model.genres.GenreResponse
import com.example.project.features.home_activity.domain.data.model.movies.MovieResponse
import com.example.project.features.home_activity.domain.data.repository.HomeRepository
import com.example.project.shared_components.API


class HomeViewModel(private val repository: HomeRepository) : ViewModel() {
    private val _genres = MutableLiveData<GenreResponse>()
    val genres: LiveData<GenreResponse> get() = _genres
    private val _movies = MutableLiveData<MovieResponse>()
    val movies: LiveData<MovieResponse> get() = _movies

    companion object {
        val genreId = MutableLiveData(1)
    }

    fun getAllGenres() {
        viewModelScope.launch {
            val response = repository.getAllGenres()
            if (response.isSuccess) {
                response.onSuccess {
                    _genres.postValue(it)
                }.onFailure {
                    //TODO
                }
            }
        }
    }

    fun getAllMoviesBasedOnGenreId(genreId: Int) {
        viewModelScope.launch {
            val response = repository.getAllMoviesBasedOnGenreId(genreId)
            if (response.isSuccess) {
                response.onSuccess {
                    _movies.postValue(it)
                }.onFailure {
                    //TODO
                }
            }
        }
    }


}

class HomeModule {
    companion object {
        val watchRepository: HomeRepository by lazy {
            HomeRepository(API.Companion.HomeService)
        }
    }
}

class HomeViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(HomeModule.watchRepository) as T
        }
        throw java.lang.IllegalArgumentException("wrong dependency")
    }
}