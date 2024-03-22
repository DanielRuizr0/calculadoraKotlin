package com.example.calculadorakotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FactorisActivity : AppCompatActivity() {

    private lateinit var etNum: EditText
    private lateinit var btnFactorizar: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factoris)

        etNum = findViewById(R.id.Num1)
        btnFactorizar = findViewById(R.id.Factorizar)
        tvResultado = findViewById(R.id.tvResultado)

        btnFactorizar.setOnClickListener {
            val numStr = etNum.text.toString()
            if (numStr.isNotEmpty()) {
                val num = numStr.toInt()
                val factorial = calcularFactorial(num)
                tvResultado.text = "El factorial de $num es: $factorial"
            } else {
                tvResultado.text = "Por favor, ingrese un número."
            }
        }
    }

    fun irAMainActivity(view: View) {
        val btnVolverMain = findViewById<Button>(R.id.regresar)
        btnVolverMain?.setOnClickListener {
            val intent = Intent(this@FactorisActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        fun calcularFactorial(Num: Int): Int {
            return if (Num == 0.toDouble().toInt() || Num == 1.toDouble().toInt()) {
                1
            } else {
                var factorial = 1
                for (i in 2..Num.toInt()) {
                    factorial *= i
                }
                factorial
            }
        }
    }
}
