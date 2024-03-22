package com.example.calculadorakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class FibonacciActivity : AppCompatActivity() {

    private lateinit var etNum: EditText
    private lateinit var btnCalcular: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci)

        etNum = findViewById(R.id.Num1)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val num = etNum.text.toString().toInt()
            val fibonacciSequence = calcularFibonacci(num)
            tvResultado.text = fibonacciSequence
        }
    }

    fun irAMainActivity(view: View) {
        val btnVolverMain = findViewById<Button>(R.id.regresar)
        btnVolverMain?.setOnClickListener {
            val intent = Intent(this@FibonacciActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun calcularFibonacci(n: Int): String {
        val sequence = StringBuilder()
        sequence.append("Fibonacci $n: ")

        for (i in 0 until n.toInt()) {
            sequence.append(fibonacci(i.toDouble())).append(", ")
        }
        return sequence.toString()
    }

    private fun fibonacci(Num: Double): Any {
        if (Num <= 1) return Num
        var fib = 1
        var prevFib = 1

        for (i in 2 until Num.toInt()) {
            val temp = fib
            fib += prevFib
            prevFib = temp
        }
        return fib
    }
}
