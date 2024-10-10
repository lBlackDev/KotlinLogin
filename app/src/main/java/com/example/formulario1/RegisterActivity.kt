package com.example.formulario1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Referencias a los componentes de la vista
        val etRut = findViewById<EditText>(R.id.etRut)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellidoPaterno = findViewById<EditText>(R.id.etApellidoPaterno)
        val etApellidoMaterno = findViewById<EditText>(R.id.etApellidoMaterno)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val rgGenero = findViewById<RadioGroup>(R.id.rgGenero)
        val etTelefono = findViewById<EditText>(R.id.etTelefono)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        // Evento del botón para registrar al usuario
        btnRegistrar.setOnClickListener {
            // Muestra la barra de progreso
            progressBar.visibility = View.VISIBLE

            // Obtención de los datos del formulario
            val rut = etRut.text.toString()
            val nombre = etNombre.text.toString()
            val apellidoPaterno = etApellidoPaterno.text.toString()
            val apellidoMaterno = etApellidoMaterno.text.toString()
            val edad = etEdad.text.toString()
            val telefono = etTelefono.text.toString()
            val direccion = etDireccion.text.toString()
            val correo = etCorreo.text.toString()

            // Validar género
            val generoId = rgGenero.checkedRadioButtonId
            val genero = if (generoId == R.id.rbMasculino) "Masculino" else "Femenino"

            // Validación básica de campos
            if (rut.isNotEmpty() && nombre.isNotEmpty() && correo.isNotEmpty()) {
                // Simula un registro exitoso
                progressBar.visibility = View.GONE

                // Navegar a la actividad de bienvenida con los datos ingresados
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("nombreCompleto", "$nombre $apellidoPaterno $apellidoMaterno")
                intent.putExtra("correo", correo)
                startActivity(intent)
            } else {
                progressBar.visibility = View.GONE
                Toast.makeText(this, "Por favor, completa todos los campos obligatorios", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
