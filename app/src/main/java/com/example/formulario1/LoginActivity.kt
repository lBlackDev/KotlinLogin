package com.example.formulario1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.formulario1.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        progressBar = findViewById(R.id.etProgress)


        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty() && password.isEmpty()) {
                mostrarToast("Falta Rellenar Campos")

            } else {
                    if (username == "rolando " && password == "1234") {
                        mostrarToast("Registro Exitoso")
                        cargando()
                        android.os.Handler().postDelayed({
                            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                            startActivity(intent)
                            finish()
                        }, 2000)

                    } else {
                        mostrarToast("Error de Autenticacion")
                    }
            }

        }
    }
        private fun mostrarToast(mensaje: String) {
            Log.d("LoginActivity", "Toast mensaje: $mensaje")
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }

        private fun cargando() {
            progressBar.visibility = View.VISIBLE
        }
}
