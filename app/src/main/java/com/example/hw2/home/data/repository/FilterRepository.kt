package com.example.hw2.home.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hw2.home.data.model.Filter

class FilterRepository {
    private val _filters = MutableLiveData<List<Filter>>()
    val filters: LiveData<List<Filter>> = _filters

    init {
        // Simulate fetching data from a remote source
        _filters.value = listOf(
            Filter("Under $220.000"),
            Filter("For Sale"),
            Filter("With Garage"),
            Filter("With Basement"),
            Filter("With Elavator"),
            Filter("Has Pool")
        )
    }

}
