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

        val namaDosen = intent.getStringExtra("EXTRA_NAMA")
        val mataKuliah = intent.getStringExtra("EXTRA_MATKUL")
        val jumlahMhs = intent.getIntExtra("EXTRA_JUMLAH", 0)
        val isPagi = intent.getBooleanExtra("EXTRA_IS_PAGI", true)

        val statusKelas: String
        val batasLulus: String
        if (isPagi) {
            statusKelas = "Reguler (Pagi)"
            batasLulus = "70"
        } else {
            statusKelas = "Karyawan (Malam)"
            batasLulus = "65"
        }

        // Tampilan Info yang lebih rapi
        tvInfoDosen.text = "DOSEN PENGAMPU  : ${namaDosen?.uppercase()}\n" +
                "MATA KULIAH     : ${mataKuliah?.uppercase()}\n" +
                "STATUS KELAS    : $statusKelas\n" +
                "SYARAT KELULUSAN: Nilai Minimal $batasLulus\n" +
                "TOTAL MAHASISWA : $jumlahMhs Orang"

        // Desain Tabel ASCII untuk Daftar Absen
        val stringBuilder = java.lang.StringBuilder()
        stringBuilder.append("--------------------------------------------------\n")
        stringBuilder.append("NO | NAMA MAHASISWA         | NILAI AKHIR | STATUS\n")
        stringBuilder.append("--------------------------------------------------\n")

        for (i in 1..jumlahMhs) {
            // Membuat angka urut rata kanan agar rapi (misal: " 1", " 2", "10")
            val no = i.toString().padEnd(2, ' ')
            stringBuilder.append("$no | ______________________ | [       ]   | ______\n")
        }
        stringBuilder.append("--------------------------------------------------\n")

        tvDaftarAbsen.text = stringBuilder.toString()
    }
}