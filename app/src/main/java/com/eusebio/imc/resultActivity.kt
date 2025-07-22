package com.eusebio.imc

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class resultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val imcText = findViewById<TextView>(R.id.IMC)
        val status = findViewById<TextView>(R.id.status)
        val message = findViewById<TextView>(R.id.resultMessage)
        val mainLayout = findViewById<ConstraintLayout>(R.id.main)
        val btnBack = findViewById<MaterialButton>(R.id.btnBack)

        // Padding original
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

        btnBack.setOnClickListener {
            navigateToHome()
        }

        val IMC = intent.getDoubleExtra("IMC", 0.0)

        calculateResult(IMC, imcText, status, message)
    }

    private fun calculateResult(
        IMC: Double,
        imcText: TextView,
        status: TextView,
        message: TextView
    ) {
        imcText.text = String.format("%.2f", IMC)

        when (IMC) {
            in 0.0..19.99 -> {
                message.text = "Recomendación: mejora tu ingesta calórica."
                status.text = "Peso Bajo"
                status.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
            }

            in 20.0..24.99 -> {
                message.text = "Excelente forma física."
                status.text = "Peso Ideal"
                status.setTextColor(ContextCompat.getColor(this, R.color.peso_ideal))
            }

            in 25.0..29.99 -> {
                message.text = "Cuidado con tu alimentación y actividad física."
                status.text = "Sobrepeso."
                status.setTextColor(ContextCompat.getColor(this, R.color.peso_alto))
            }

            in 30.0..34.99 -> {
                message.text = "Comienza un plan para mejorar tu salud."
                status.text = "Obesidad I."
                status.setTextColor(ContextCompat.getColor(this, R.color.peso_alto))
            }

            in 35.0..39.99 -> {
                message.text = "Requiere intervención médica."
                status.text = "Obesidad II."
                status.setTextColor(ContextCompat.getColor(this, R.color.peso_alto))
            }

            in 40.0..100.0 -> {
                message.text = "Peligro para la salud. Urgente actuar."
                status.text = "Obesidad III."
                status.setTextColor(ContextCompat.getColor(this, R.color.peso_alto))
            }

            else -> {
                message.text = "error"
                status.text = "-1."
                status.setTextColor(ContextCompat.getColor(this, R.color.peso_alto))
            }
        }
    }

    private fun navigateToHome(){
        val intent = Intent(this, MainActivity::class.java)

        //navegar hacia la vista principal
        startActivity(intent)
    }
}
