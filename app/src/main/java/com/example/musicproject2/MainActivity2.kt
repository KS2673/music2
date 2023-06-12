package com.example.musicproject2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.musicproject2.R


class MainActivity2 : AppCompatActivity() {

    lateinit var receiver_msg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        receiver_msg = findViewById(R.id.received_value_id)
        // create the get Intent object
        val intent = intent
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        val str = intent.getStringExtra("message_key")
        // display the string into textView
        receiver_msg.text = str
    }
}
