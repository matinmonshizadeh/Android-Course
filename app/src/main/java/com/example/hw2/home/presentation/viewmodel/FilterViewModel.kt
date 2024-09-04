package com.example.hw2.home.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw2.home.data.model.Filter
import com.example.hw2.home.data.repository.FilterRepository

class FilterViewModel :ViewModel(){
    private val filterRepository = FilterRepository()

    fun getFilters(): LiveData<List<Filter>> {
        return filterRepository.filters
    }
}