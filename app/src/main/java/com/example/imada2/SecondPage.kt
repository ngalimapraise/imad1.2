package com.example.imada2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        var feedbutton = findViewById<Button>(R.id.FEED)
        var cleanbutton = findViewById<Button>(R.id.CLEAN)
        var playButton = findViewById<Button>(R.id.PLAY)
        var home = findViewById<Button>(R.id.HOME)
        var comment = findViewById<TextView>(R.id.COMMENT)
        var hungerView = findViewById<TextView>(R.id.HUNGER)
        var cleanView = findViewById<TextView>(R.id.CLEANTEXT)
        var happyView = findViewById<TextView>(R.id.HAPPY)
        var image = findViewById<ImageView>(R.id.IMAGE)
        // this decleration gets the inputed name from the first page and uses the data on this page.
        var Intent = intent
        var name= Intent.getStringExtra("name")

        // these are the numbers the dog is going to start on when app is launched
        var food = 4
        var funn = 4
        var cleaness = 4

        // function for feed, this is what will happen when the feed button is pressed
        // the less the hunger is the more hungry the dog will be
        // while the dog eats it also gets dirty, that's why cleaness decreases
        fun food() {
            if (food >= 0 && food < 10 && cleaness > 0) {
                comment.text = " $name is eating."
                food += 1
                cleaness -= 1
                hungerView.text = "$food"
                cleanView.text = "$cleaness"
                happyView.text = "$funn"
                image.setImageDrawable(getDrawable(R.drawable.dog_eating))
            } else if (food == 10) {
                comment.text = "$name is full."
                hungerView.text = "$food"
                cleanView.text = "$cleaness"
                happyView.text = "$funn"
                image.setImageDrawable(getDrawable(R.drawable.dog_full))
            } else {
                comment.text = "$name needs a bath."
                hungerView.text = "$food"
                cleanView.text = "$cleaness"
                happyView.text = "$funn"
                image.setImageDrawable(getDrawable(R.drawable.dirty_dog))
            }

        }
        // the higher the clean value goes up the more clean the dog becomes
        // the cleaner it gets the more it wants to play.
        fun clean() {
            if (cleaness >= 0 && cleaness < 10 && funn > 0) {
                comment.text = "$name is bathing."
                cleaness += 1
                funn -= 1
                hungerView.text = "$food"
                cleanView.text = "$cleaness"
                happyView.text = "$funn"
                image.setImageDrawable(getDrawable(R.drawable.dog_bathing))
            } else if (cleaness == 10) {
                comment.text = "$name is completley clean."
                hungerView.text = "$food"
                cleanView.text = "$cleaness"
                happyView.text = "$funn"
                image.setImageDrawable(getDrawable(R.drawable.clean_dog))
            } else {
                comment.text = "$name wants to play."
                hungerView.text = "$food"
                cleanView.text = "$cleaness"
                happyView.text = "$funn"
                image.setImageDrawable(getDrawable(R.drawable.dog_wants_to_play_))
            }
        }
        //the higher the happy number increases that means the dog is having a lot of fun
        // the more energy it uses the more hungry it gets thus hunger decreases
        fun plaay() {
            if (funn >= 0 && funn < 10 && food > 0) {
                comment.text = "$name is playing."
                funn += 1
                food -= 1
                hungerView.text = "$food"
                cleanView.text = "$cleaness"
                happyView.text = "$funn"
                image.setImageDrawable(getDrawable(R.drawable.dog_playing))
            } else if (funn == 10) {
                comment.text = "$name is tired."
                hungerView.text = "$food"
                cleanView.text = "$cleaness"
                happyView.text = "$funn"
                image.setImageDrawable(getDrawable(R.drawable.tired_dog))

            } else {
                comment.text = " Feed $name."
                hungerView.text = "$food"
                cleanView.text = "$cleaness"
                happyView.text = "$funn"
                image.setImageDrawable(getDrawable(R.drawable.hungry_dog))
            }
        }
        feedbutton.setOnClickListener {
            food()
        }
        cleanbutton.setOnClickListener {
            clean()
        }
        playButton.setOnClickListener {
            plaay()
        }

        // this helps user go back to the start this thus means dog will be reset.
        home.setOnClickListener {
            val Intent1 = Intent( this, MainActivity::class.java)
            startActivity(Intent1)
        }


    }
}





