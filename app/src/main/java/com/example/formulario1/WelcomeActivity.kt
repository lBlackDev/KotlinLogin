package com.example.formulario1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Obtener los datos enviados desde la actividad de registro
        val nombreCompleto = intent.getStringExtra("nombreCompleto")
        val correo = intent.getStringExtra("correo")

        // Referencias a los componentes de la vista
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val tvNombreCompleto = findViewById<TextView>(R.id.tvNombreCompleto)
        val tvCorreo = findViewById<TextView>(R.id.tvCorreo)

        // Mostrar los datos en la vista
        tvNombreCompleto.text = "Nombre Completo: $nombreCompleto"
        tvCorreo.text = "Correo: $correo"
    }
}
