package com.app.pack.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.pack.model.Post
import com.app.pack.repository.MainRepository
import com.app.pack.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) :ViewModel() {

    private val postStateFlow : MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    // StateFlow will carry state in the mainUI
    val postState : StateFlow<ApiState> = postStateFlow

    fun getPost() = viewModelScope.launch {
        postStateFlow.value  = ApiState.Loading
        repository.getPost()
            .catch { e ->
                postStateFlow.value = ApiState.Failure(e)
                //catch means failure
            }.collect {
                //collect means success

                postStateFlow.value = ApiState.Success(it)
            }

    }



}