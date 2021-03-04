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


        val job = GlobalScope.launch(Dispatchers.Default) {
                repeat(5){
                    Log.d(TAG, "Coroutine is still working...")
                    delay(1000L)
            }

        }

        runBlocking {
            delay(2000L)
            job.cancel()
            Log.d(TAG, "Main thread continung")
        }

        
        

    }




}