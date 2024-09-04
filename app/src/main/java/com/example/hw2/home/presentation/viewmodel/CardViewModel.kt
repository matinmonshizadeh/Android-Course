package com.example.hw2.home.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw2.home.data.model.Card
import com.example.hw2.home.data.repository.CardRepository


class CardViewModel : ViewModel(){
    private val cardRepository = CardRepository()

    fun getCards(): LiveData<List<Card>> {
        return cardRepository.filters
    }

}