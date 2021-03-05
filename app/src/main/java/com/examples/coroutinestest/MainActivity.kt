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
                val answer1 = async { networkCall1() }
                val answer2 = async { networkCall2() }
                Log.d(TAG, "Answer1 is: ${answer1.await()}")
                Log.d(TAG, "Answer2 is: ${answer2.await()}")
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