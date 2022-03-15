package com.example.popcorn

import android.app.Application
import com.example.popcorn.di.ApplicationComponent
import com.example.popcorn.di.DaggerApplicationComponent

class PopCornApplication : Application(){

   val appComponent: ApplicationComponent = DaggerApplicationComponent.builder().build()

}