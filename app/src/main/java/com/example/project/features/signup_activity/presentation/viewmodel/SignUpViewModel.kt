package com.example.project.features.signup_activity.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.project.features.signup_activity.domain.data.model.user.User
import com.example.project.features.signup_activity.domain.data.repository.SignUpRepository
import com.example.project.shared_components.API
import kotlinx.coroutines.launch

class SignUpViewModel(private val repository: SignUpRepository) : ViewModel() {
    fun setUser(user: User) {
        viewModelScope.launch {
            val response = repository.setUser(user)
            if (response.isSuccess) {
                response.onSuccess {
                    //TODO
                }.onFailure {
                    //TODO
                }
            }
        }
    }
}

class SignUpModule {
    companion object {
        val watchRepository: SignUpRepository by lazy {
            SignUpRepository(API.Companion.SignUpService)
        }
    }
}

class SignUpViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel(SignUpModule.watchRepository) as T
        }
        throw java.lang.IllegalArgumentException("wrong dependency")
    }
}