package com.example.project.features.search_activity.presentation.viewmodel

import androidx.lifecycle.*
import com.example.project.features.home_activity.domain.data.model.movies.MovieResponse
import com.example.project.features.search_activity.repository.SearchRepository
import com.example.project.shared_components.API
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: SearchRepository) : ViewModel() {
    private val _movies = MutableLiveData<MovieResponse>()
    val movies: LiveData<MovieResponse> get() = _movies

    fun getMoviesBasedOnQuery(query: String) {
        viewModelScope.launch {
            val response = repository.getMoviesBasedOnQuery(query)
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


class SearchModule {
    companion object {
        val watchRepository: SearchRepository by lazy {
            SearchRepository(API.Companion.SearchService)
        }
    }
}

class SearchViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(SearchModule.watchRepository) as T
        }
        throw java.lang.IllegalArgumentException("wrong dependency")
    }
}