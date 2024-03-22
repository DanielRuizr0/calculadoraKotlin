package com.example.calculadorakotlin

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class FactorialCalculatorTest {
    private var calculator: factorisActivity? = null

    class factorisActivity {

    }

    @Before
    fun setUp() {
        calculator = factorisActivity()
    }

    @Test
    fun testCalcularFactorial_CasoBase() {
        assertEquals(1, calculator.calcularFactorial(0))
    }

    @Test
    fun testCalcularFactorial_NumeroPositivo() {
        assertEquals(120, calculator.calcularFactorial(5))
    }

    @Test(expected = IllegalArgumentException::class)
    fun testCalcularFactorial_NumeroNegativo() {
        calculator.calcularFactorial(-5)
    }
}

private fun FactorialCalculatorTest.factorisActivity?.calcularFactorial(i: Int) {

}
