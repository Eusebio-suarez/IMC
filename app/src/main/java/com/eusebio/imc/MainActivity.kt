package com.eusebio.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.filament.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    private var isMaleSelected = true
    private var isFemaleSelected = false

    private var height = 170

    private var weight = 60

    private var age = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<ConstraintLayout>(R.id.main)

        // guarda el padding original del XML
        val originalPaddingTop = mainLayout.paddingTop
        val originalPaddingBottom = mainLayout.paddingBottom
        val originalPaddingLeft = mainLayout.paddingLeft
        val originalPaddingRight = mainLayout.paddingRight

        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left + originalPaddingLeft,
                systemBars.top + originalPaddingTop,
                systemBars.right + originalPaddingRight,
                systemBars.bottom + originalPaddingBottom
            )
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
        val heightRange = findViewById<Slider>(R.id.heightRange)


        //texto de el peso
        val weighttext = findViewById<TextView>(R.id.weightText)

        //texto de la edad
        var ageText = findViewById<TextView>(R.id.ageText)

        //botones de el peso
        var btnAddWeight = findViewById<FloatingActionButton>(R.id.addWeight)

        var btnSubtractWeight = findViewById<FloatingActionButton>(R.id.subtractWeight)

        //botones para controlar la edad
        var btnAddAge = findViewById<FloatingActionButton>(R.id.addAge)
        var btnSubtractAge = findViewById<FloatingActionButton>(R.id.subtractAge)


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

        //evento para agregar peso
        btnAddWeight.setOnClickListener(){
            weight++
            weighttext.text = weight.toString()
        }

        //evento para quitar peso
        btnSubtractWeight.setOnClickListener(){
            weight--
            weighttext.text = weight.toString()
        }

        //evento para agregar edad
        btnAddAge.setOnClickListener(){
            age++
            ageText.text = age.toString()
        }

        //evento para quitar edad
        btnSubtractAge.setOnClickListener(){
            age--
            ageText.text = age.toString()
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