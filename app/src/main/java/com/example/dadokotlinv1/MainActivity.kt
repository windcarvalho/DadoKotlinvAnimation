package com.example.dadokotlinv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // val txView: TextView = findViewById(R.id.textView);
        val btRoll: Button = findViewById(R.id.btRoll);
        btRoll.setOnClickListener {
            val d:Dice= Dice(6);
            val random:Int=d.rollDice()
            val drawableRes = when (random) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            
            val diceImage : ImageView = findViewById(R.id.imageView)
            diceImage.setImageResource(drawableRes)

        }

    }


}