package com.example.uts_pemrogseluler_42430043_yang

import android.content.Intent
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUser = findViewById<EditText>(R.id.etUsername)
        val etPass = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener { view ->
            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)

            val user = etUser.text.toString()
            val pass = etPass.text.toString()

            // Login sederhana: admin / 123
            if (user == "admin" && pass == "123") {
                // PINDAH KE GENERATOR (MainActivity)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            } else {
                view.performHapticFeedback(HapticFeedbackConstants.REJECT)
                Toast.makeText(this, "Akses Ditolak! Cek kembali", Toast.LENGTH_SHORT).show()
            }
        }
    }
}