package com.example.dadokotlinv1

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var rolaDadoAnim: Animation
    var faceAtual by Delegates.notNull<Int>()

    @SuppressLint("UseCompatLoadingForDrawables")
    // Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v ("chave", "valor da face="+ (savedInstanceState?.getInt("face") ?: 0))
        //Carrega face anterior
        val faceAnt = savedInstanceState?.getInt("face") ?: 0
        val drawableRes =    when (faceAnt) {
            0,1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val diceImage: ImageView = findViewById(R.id.imageView)

        diceImage.setImageDrawable(ContextCompat.getDrawable(this,drawableRes))


        // load the animation
        rolaDadoAnim = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.roladadoanim
        )
        rolaDadoAnim.setAnimationListener(this)


       // val txView: TextView = findViewById(R.id.textView);
        val btRoll: Button = findViewById(R.id.btRoll);
        btRoll.setOnClickListener {
            val d:Dice= Dice(6);
            val diceImage: ImageView = findViewById(R.id.imageView)
            diceImage.startAnimation(rolaDadoAnim)

            val random: Int = d.rollDice()
            faceAtual = random
            val drawableRes =    when (random) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }
            diceImage.setImageDrawable(ContextCompat.getDrawable(this,drawableRes))

        }



    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("face",faceAtual)
        super.onSaveInstanceState(outState)
    }


    override fun onAnimationStart(animation: Animation?) {
        if (animation ==rolaDadoAnim) {
            Log.v("pdm","animacao começando")
        }
    }

    override fun onAnimationEnd(animation: Animation?) {
        Log.v("pdm","animacao terminando")
    }

    override fun onAnimationRepeat(animation: Animation?) {
        Log.v("pdm","animacao repetindo")
    }


}