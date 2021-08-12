package com.example.daggerhiltconceptexample.Example3

import android.app.Application
import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Inject
import javax.inject.Singleton


interface One{   // Creating an Interface
    fun getName()
}
class ImplementOne @Inject constructor(private val name : String): One{  // Creating Class and Implement Method and providing Dependency or objects
    override fun getName() {
        Log.d("main", "my name is $name")

    }
}

class Main @Inject constructor (private val one: One){

    fun getName(){
        one.getName()
    }
}
@Module   //If you want to provide DI to an Interface then you can use @Module Annotation
@InstallIn(Application :: class) //this is used to know that where to use this Di in which component
abstract class AppModule{

    @Binds
    @Singleton
    abstract fun binding(implementOne: ImplementOne): One
}

@Module
@InstallIn(Application::class)
class AppModules{

    @Provides
    @Singleton
    fun getName() : String = "sohil"

    @Provides
    @Singleton  // This can be used anywhere in the application

    fun binding( name : String) : One = ImplementOne(name)

}

