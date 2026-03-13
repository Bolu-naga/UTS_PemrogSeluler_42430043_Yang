package com.example.uts_pemrogseluler_42430043_yang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNamaDosen = findViewById<EditText>(R.id.etNamaDosen)
        val etMataKuliah = findViewById<EditText>(R.id.etMataKuliah)
        val etJumlahMahasiswa = findViewById<EditText>(R.id.etJumlahMahasiswa)
        val rbPagi = findViewById<RadioButton>(R.id.rbPagi)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)

        btnGenerate.setOnClickListener {
            val nama = etNamaDosen.text.toString()
            val matkul = etMataKuliah.text.toString()
            val jumlahStr = etJumlahMahasiswa.text.toString()

            if (nama.isEmpty() || matkul.isEmpty() || jumlahStr.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // MODUL 4: Intent & Data Passing
            val intent = Intent(this, PanelActivity::class.java)
            intent.putExtra("EXTRA_NAMA", nama)
            intent.putExtra("EXTRA_MATKUL", matkul)
            intent.putExtra("EXTRA_JUMLAH", jumlahStr.toInt())
            intent.putExtra("EXTRA_IS_PAGI", rbPagi.isChecked)

            startActivity(intent)
        }
    }
}