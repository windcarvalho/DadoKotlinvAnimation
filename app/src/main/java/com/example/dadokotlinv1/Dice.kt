package com.example.dadokotlinv1

import android.util.Log
import kotlin.random.Random

data class Dice (val numFaces:Int) {
   var number:Int = 0
           get() = field
            set(newValue) {
                if ((newValue <= numFaces)&&(newValue >= 1)) {
                    field = newValue
                }
                else {
                    Log.v("pdm", "Tentaram alterar o valor de forma errada")
                }
            }

    fun rollDice():Int{
        this.number = Random.nextInt(this.numFaces) +1
        return this.number
    }
}