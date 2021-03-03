package com.examples.coroutinestest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)


        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG, "Atarting coroutine in thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()

            withContext(Dispatchers.Main){
                Log.d(TAG, "Atarting coroutine in thread ${Thread.currentThread().name}")
                textView.text = answer
            }



        }
        Log.d(TAG, "Hello from thread here ${Thread.currentThread().name}")
        

    }

    suspend fun doNetworkCall(): String{
        delay(5000L)
        return "Answer"
    }

    suspend fun doNetworkCall2(): String{
        delay(1000L)
        return "This is answer 2"
    }


}