package com.examples.coroutinestest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    lateinit var btnStart: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart = findViewById(R.id.buttonStartActivity)

        btnStart.setOnClickListener {
            GlobalScope.launch {
                while (true){
                    delay(1000L)
                    Log.d(TAG, "Still running...")
                }
            }
            GlobalScope.launch {
                delay(5000L)
                Log.d(TAG, "Start Activity")
                Intent(this@MainActivity, SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }






}