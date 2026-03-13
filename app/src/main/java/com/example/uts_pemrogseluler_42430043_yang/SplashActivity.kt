package com.example.uts_pemrogseluler_42430043_yang

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Menunda selama 2500 milidetik (2,5 detik)
        Handler(Looper.getMainLooper()).postDelayed({
            // Pindah ke MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            // Menambahkan animasi fade in & fade out ala premium
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            // Menutup Splash Screen agar tidak bisa di-back
            finish()
        }, 2500)
    }
}