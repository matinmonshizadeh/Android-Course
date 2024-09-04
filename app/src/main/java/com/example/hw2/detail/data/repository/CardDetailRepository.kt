package com.example.hw2.detail.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hw2.detail.data.model.CardDetail


class CardDetailRepository {
    private val _details = MutableLiveData<List<CardDetail>>()
    val details: LiveData<List<CardDetail>> = _details

    init {
        // Simulate fetching data from a remote source
        _details.value = listOf(
            CardDetail("500", "Square foot"),
            CardDetail("4", "Bedrooms"),
            CardDetail("2", "Bathrooms"),
            CardDetail("1", "Toilet"),
            CardDetail("2", "Garage"),
            CardDetail("1", "Elevator"),
        )
    }

}