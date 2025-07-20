package com.eusebio.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {
    private var isMaleSelected = true
    private var isFemaleSelected = false

    private var height = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //genders

        //male card
        val maleCard = findViewById<CardView>(R.id.maleCard)

        //female card
        val femaleCard = findViewById<CardView>(R.id.femaleCard)

        //altura
        val heightText = findViewById<TextView>(R.id.height)

        //rangon de altura
        val heightRange = findViewById<RangeSlider>(R.id.heightRange)


        //eventos para cambiar el genero
        maleCard.setOnClickListener {
            selectedGender(true,maleCard,femaleCard)
        }

        femaleCard.setOnClickListener {
            selectedGender(false,maleCard,femaleCard)
        }

        //evento para actualizar el valor de la altura
        heightRange.addOnChangeListener { slider, value,_->
            //cambiar el el valor de la altura
            heightText.text = "${value.toInt()} cm"
            setHeight(value.toInt())
        }

    }

    //funcion para seleccionar un genero
    private fun selectedGender(isMale: Boolean,maleCard: CardView,femaleCard: CardView) {
        if (isMale){
            isMaleSelected = true
            isFemaleSelected = false
            maleCard.setCardBackgroundColor(Color.parseColor("#212025"))
            femaleCard.setCardBackgroundColor(Color.parseColor("#3a3941"))
        }
        else{
            isMaleSelected = false
            isFemaleSelected = true
            maleCard.setCardBackgroundColor(Color.parseColor("#3a3941"))
            femaleCard.setCardBackgroundColor(Color.parseColor("#212025"))
        }
    }

    //cambiar elm valor de la altura
    private fun setHeight(value: Int){
        height=value
    }

}