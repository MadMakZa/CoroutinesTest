package com.examples.coroutinestest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }




    private fun task1(){
        Log.d("log","Hello ")
    }
    suspend fun task2(){
        Log.d("log","World!")
    }
}