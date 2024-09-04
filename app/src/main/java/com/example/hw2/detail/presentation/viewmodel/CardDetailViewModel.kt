package com.example.hw2.detail.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw2.detail.data.model.CardDetail
import com.example.hw2.detail.data.repository.CardDetailRepository

class CardDetailViewModel : ViewModel(){
    private val cardDetailRepository = CardDetailRepository()

    fun getCardDetails(): LiveData<List<CardDetail>> {
        return cardDetailRepository.details
    }
}