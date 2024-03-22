package com.example.calculadorakotlin

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class FibonacciTest {
    private var mathFunctions: FibonacciActivity? = null
    @Before
    fun setUp() {
        mathFunctions = FibonacciActivity()
    }

    @Test
    fun testCalcularFibonacci_CasoBase() {
        assertEquals(
            "Secuencia de Fibonacci hasta el término 0: ",
            mathFunctions!!.calcularFibonacci(0)
        )
    }

    @Test
    fun testCalcularFibonacci_HastaTres() {
        assertEquals(
            "Secuencia de Fibonacci hasta el término 3: 0, 1, 1, ",
            mathFunctions!!.calcularFibonacci(3)
        )
    }
}
