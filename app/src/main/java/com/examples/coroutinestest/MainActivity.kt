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
            Log.d(TAG, "Starting long running calculation...")
            for (i in 30..40){
                if(isActive) {
                    Log.d(TAG, "Result for i = $i: ${fib(i)}")
                }
            }


        }

        runBlocking {
            delay(2000L)
            job.cancel()
            Log.d(TAG, "Canceled job")
        }

    }

    fun fib(n: Int): Long{
        return if (n == 0) 0
        else if (n == 1) 1
        else fib (n - 1) + fib (n - 2)
    }




}