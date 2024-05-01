package com.example.imada2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       // once button is pressed it should lead to the next page.
        val startButton = findViewById<Button>(R.id.START)

        // this gives the user the freedom to give the pet a name
        val name = findViewById<EditText>(R.id.NAME)

        val userName = name.text.toString()
        startButton.setOnClickListener {
            val Intent = Intent( this, SecondPage::class.java)
            Intent.putExtra("name",name.text.toString())
            startActivity(Intent)
        }

    }
}