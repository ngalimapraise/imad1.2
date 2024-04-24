package com.example.imada2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_page)

        val feedButton = findViewById<Button>(R.id.FEED)
        val cleanButton = findViewById<Button>(R.id.CLEAN)
        val playButton = findViewById<Button>(R.id.PLAY)
        var hungerView = findViewById<TextView>(R.id.HUNGER)
        var cleanView = findViewById<TextView>(R.id.CLEANTEXT)
        var happyView = findViewById<TextView>(R.id.HAPPY)
        var image = findViewById<ImageView>(R.id.IMAGE)


        feedButton.setOnClickListener {
            hungerView.text= "0"
            cleanView.text="3"
            happyView.text="10"
            image.setImageDrawable(getDrawable(R.drawable.dog_eating))
        }
        cleanButton.setOnClickListener {
            hungerView.text= "6"
            cleanView.text="10"
            happyView.text="8"
            image.setImageDrawable(getDrawable(R.drawable.dog_bathing))
        }
        playButton.setOnClickListener {
            hungerView.text= "9"
            cleanView.text="3"
            happyView.text="10"
            image.setImageDrawable(getDrawable(R.drawable.dog_playing))
        }
        }
    }

