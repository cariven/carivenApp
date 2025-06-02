package com.example.carivenapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.carivenapp.ui.theme.CarivenAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cariven)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val txtHasil = findViewById<TextView>(R.id.txtHasil)

        val btnTambah = findViewById<Button>(R.id.btnTambah)
        val btnKali = findViewById<Button>(R.id.btnKali)
        val btnBagi = findViewById<Button>(R.id.btnBagi)

        btnTambah.setOnClickListener {
            val hasil = ambilAngka(number1, number2)?.let { it.first + it.second }
            txtHasil.text = hasil?.toString() ?: "Error"
        }

        btnKali.setOnClickListener {
            val hasil = ambilAngka(number1, number2)?.let { it.first * it.second }
            txtHasil.text = hasil?.toString() ?: "Error"
        }

        btnBagi.setOnClickListener {
            val angka = ambilAngka(number1, number2)
            val hasil = if (angka != null && angka.second != 0.0)
                angka.first / angka.second else null
            txtHasil.text = hasil?.toString() ?: "Error"
        }
    }

    private fun ambilAngka(n1: EditText, n2: EditText): Pair<Double, Double>? {
        return try {
            val a = n1.text.toString().toDouble()
            val b = n2.text.toString().toDouble()
            Pair(a, b)
        } catch (e: NumberFormatException) {
            null
        }
    }
}