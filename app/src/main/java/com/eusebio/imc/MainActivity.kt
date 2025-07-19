package com.eusebio.imc

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var isMaleSelected = true
    private var isFemaleSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //male card
        val maleCard = findViewById<CardView>(R.id.maleCard)

        //female card
        val femaleCard = findViewById<CardView>(R.id.femaleCard)

        maleCard.setOnClickListener {
            selectedGender(true,maleCard,femaleCard)
        }

        femaleCard.setOnClickListener {
            selectedGender(false,maleCard,femaleCard)
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

}