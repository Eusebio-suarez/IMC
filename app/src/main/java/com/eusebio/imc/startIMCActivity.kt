package com.eusebio.imc

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class startIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcactivity)
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

        //boton de inicio
        val btnStar = findViewById<MaterialButton>(R.id.btnStart)

        //agregar el evento de click
        btnStar.setOnClickListener { navigateToHome() }
    }
    //funciona para navegar
    private fun navigateToHome(){
        val intent = Intent(this, MainActivity::class.java)

        //navegar hacia la vista principal
        startActivity(intent)
    }
}