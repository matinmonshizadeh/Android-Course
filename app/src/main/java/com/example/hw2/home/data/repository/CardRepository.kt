package com.example.hw2.home.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hw2.R
import com.example.hw2.home.data.model.Card


class CardRepository {
    private val _cards = MutableLiveData<List<Card>>()
    val filters: LiveData<List<Card>> = _cards

    init {
        // Simulate fetching data from a remote source
        _cards.value = listOf(
            Card(R.drawable.house1, "200.000", "Potrero Hil", "4", "2", "1.210"),
            Card(R.drawable.house2, "120.000", "Alice Griffith", "2", "1", "1.340"),
            Card(R.drawable.house3, "340.000", "Sunnydale", "5", "2", "1.510"),
            Card(R.drawable.house4, "510.000", "Potrero Hil", "6", "3", "2.210"),
            Card(R.drawable.house5, "170.000", "Sunnydale", "3", "2", "1.570"),
        )
    }
}