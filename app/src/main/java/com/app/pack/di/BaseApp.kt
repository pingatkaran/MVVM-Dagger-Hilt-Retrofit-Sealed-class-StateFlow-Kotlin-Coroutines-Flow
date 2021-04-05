package com.app.pack.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp : Application() {

    // this is container
    // add the dependecies
    // like provide acitivty, service and fragment

}