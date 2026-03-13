package com.example.uts_pemrogseluler_42430043_yang

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)

        val tvInfoDosen = findViewById<TextView>(R.id.tvInfoDosen)
        val tvDaftarAbsen = findViewById<TextView>(R.id.tvDaftarAbsen)

        // Menangkap data dari Intent
        val namaDosen = intent.getStringExtra("EXTRA_NAMA")
        val mataKuliah = intent.getStringExtra("EXTRA_MATKUL")
        val jumlahMhs = intent.getIntExtra("EXTRA_JUMLAH", 0)
        val isPagi = intent.getBooleanExtra("EXTRA_IS_PAGI", true)

        // MODUL 5: Implementasi If-Else
        val statusKelas: String
        val batasLulus: String
        if (isPagi) {
            statusKelas = "Reguler (Pagi)"
            batasLulus = "70"
        } else {
            statusKelas = "Karyawan (Malam)"
            batasLulus = "65"
        }

        // Tampilkan Info Header
        tvInfoDosen.text = "Dosen Pengampu : $namaDosen\n" +
                "Mata Kuliah    : $mataKuliah\n" +
                "Status Kelas   : $statusKelas\n" +
                "Target Lulus   : > $batasLulus\n" +
                "Jumlah Mhs     : $jumlahMhs Orang"

        // MODUL 5: Implementasi For Loop
        val stringBuilder = java.lang.StringBuilder()
        for (i in 1..jumlahMhs) {
            stringBuilder.append("$i. Nama: ______________ | Nilai: [    ]\n")
        }

        tvDaftarAbsen.text = stringBuilder.toString()
    }
}