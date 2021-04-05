package com.app.pack.util

import com.app.pack.model.Post

sealed class ApiState{

    // Any State in application are introduce here

    // Manage State such as Loading State,Various, Sucess state which we get from server
    // so sealed class is used here
    // work as abstract

    object Loading : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    class Success(val data: List<Post>) : ApiState()
    object Empty : ApiState()

}
