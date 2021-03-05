package com.examples.coroutinestest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)

        GlobalScope.launch { (Dispatchers.IO)
            val time = measureTimeMillis {
                var answer1: String? = null
                var answer2: String? = null
                val job1 = launch { answer1 = networkCall1() }
                val job2 = launch { answer2 = networkCall2() }
                job1.join()
                job2.join()
                Log.d(TAG, "Answer1 is: $answer1")
                Log.d(TAG, "Answer2 is: $answer2")
            }
            Log.d(TAG, "Request took $time ms.")
        }

    }

    suspend fun networkCall1(): String {
        delay(3000L)
        return "Answer 1"
    }

    suspend fun networkCall2(): String {
        delay(3000L)
        return "Answer 2"
    }




}