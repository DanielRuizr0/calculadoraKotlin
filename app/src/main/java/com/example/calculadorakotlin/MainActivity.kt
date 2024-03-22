package com.example.calculadorakotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNum1: EditText
    private lateinit var etNum2: EditText
    private lateinit var btnSumar: Button
    private lateinit var btnRestar: Button
    private lateinit var btnMultiplicar: Button
    private lateinit var btnDividir: Button
    private lateinit var tvResultado: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)
        btnSumar = findViewById(R.id.suma)
        btnRestar = findViewById(R.id.resta)
        btnMultiplicar = findViewById(R.id.multiplicacion)
        btnDividir = findViewById(R.id.division)
        tvResultado = findViewById(R.id.resultado)

        btnSumar.setOnClickListener {
            val num1 = etNum1.text.toString().toInt()
            val num2 = etNum2.text.toString().toInt()
            val resultado = Suma.sumar(num1, num2)
            tvResultado.text = resultado.toString()
        }

        btnRestar.setOnClickListener {
            val num1 = etNum1.text.toString().toInt()
            val num2 = etNum2.text.toString().toInt()
            val resultado = Resta.restar(num1, num2)
            tvResultado.text = resultado.toString()
        }

        btnMultiplicar.setOnClickListener {
            val num1 = etNum1.text.toString().toInt()
            val num2 = etNum2.text.toString().toInt()
            val resultado = Multiplicacion.multiplicar(num1, num2)
            tvResultado.text = resultado.toString()
        }

        btnDividir.setOnClickListener {
            val num1 = etNum1.text.toString().toInt()
            val num2 = etNum2.text.toString().toInt()
            try {
                val resultado = Division.dividir(num1, num2)
                tvResultado.text = resultado.toString()
            } catch (e: IllegalArgumentException) {
                tvResultado.text = "No se puede dividir por cero"
            }
        }
    }

    fun irAfactorisActivity(view: View) {
        val intent = Intent(this, FactorisActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun irAFibonacciActivity(view: View) {
        val intent = Intent(this, FibonacciActivity::class.java)
        startActivity(intent)
        finish()
    }

    object Suma {
        fun sumar(a: Int, b: Int): Int {
            return if (b == 0) a else sumar(a xor b, (a and b) shl 1)
        }
    }

    object Resta {
        fun restar(a: Int, b: Int): Int {
            return if (b == 0) a else restar(a xor b, (a.inv() and b) shl 1)
        }
    }

    object Multiplicacion {
        fun multiplicar(a: Int, b: Int): Int {
            return when {
                b == 0 -> 0
                b > 0 -> a + multiplicar(a, b - 1)
                else -> -multiplicar(a, -b)
            }
        }
    }

    object Division {
        fun dividir(dividend: Int, divisor: Int): Int {
            return when {
                divisor == 0 -> throw IllegalArgumentException("No se puede dividir por cero")
                dividend < divisor -> 0
                else -> 1 + dividir(dividend - divisor, divisor)
            }
        }
    }
}
