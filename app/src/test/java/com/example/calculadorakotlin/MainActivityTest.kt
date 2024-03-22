package com.example.calculadorakotlin

import org.junit.Assert.assertEquals
import org.junit.Test


class MainActivityTest {
    @Test
    fun testSumar() {
        assertEquals(5, MainActivity.Suma.sumar(2, 3))
        assertEquals(7, MainActivity.Suma.sumar(5, 2))
        assertEquals(10, MainActivity.Suma.sumar(7, 3))
        assertEquals(-1, MainActivity.Suma.sumar(-5, 4))
        assertEquals(0, MainActivity.Suma.sumar(0, 0))
        assertEquals(10, MainActivity.Suma.sumar(0, 10))
        assertEquals(-15, MainActivity.Suma.sumar(-10, -5))
    }

    @Test
    fun testRestar() {
        assertEquals(3, MainActivity.Resta.restar(5, 2))
        assertEquals(-2, MainActivity.Resta.restar(3, 5))
        assertEquals(0, MainActivity.Resta.restar(10, 10))
        assertEquals(8, MainActivity.Resta.restar(10, 2))
        assertEquals(-8, MainActivity.Resta.restar(2, 10))
        assertEquals(10, MainActivity.Resta.restar(10, 0))
    }

    @Test
    fun testMultiplicar() {
        assertEquals(0, MainActivity.Multiplicacion.multiplicar(0, 5))
        assertEquals(0, MainActivity.Multiplicacion.multiplicar(5, 0))
        assertEquals(10, MainActivity.Multiplicacion.multiplicar(2, 5))
        assertEquals(-10, MainActivity.Multiplicacion.multiplicar(-2, 5))
        assertEquals(-10, MainActivity.Multiplicacion.multiplicar(2, -5))
        assertEquals(10, MainActivity.Multiplicacion.multiplicar(-2, -5))
    }

    @Test
    fun testDividir() {
        assertEquals(2, MainActivity.Division.dividir(10, 5))
        assertEquals(3, MainActivity.Division.dividir(15, 5))
        assertEquals(0, MainActivity.Division.dividir(5, 10))
        assertEquals(1, MainActivity.Division.dividir(5, 3))
    }

    @Test(expected = IllegalArgumentException::class)
    fun testDividirPorCero() {
        MainActivity.Division.dividir(10, 0)
    }
}