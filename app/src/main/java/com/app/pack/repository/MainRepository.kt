package com.app.pack.repository

import com.app.pack.model.Post
import com.app.pack.network.ApiServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiServiceImpl: ApiServiceImpl) {

    // Use of FLow
    // This can fetch multiple data
    // if doing with coroutine or suspend, it will do only one
    // sequence one by one
    // so use flow


    // we need to emit to give data to viewModel


    fun getPost() : Flow<List<Post>> = flow {
        emit(apiServiceImpl.getPost())
    }.flowOn(Dispatchers.IO)

}