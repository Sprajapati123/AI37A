package com.example.ai37a

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock

class CalculationUnitTest {

    @Test
    fun add_test(){
        val calculation = Calculation()

        val result = calculation.add(5,5)

        assertEquals(9,result)
    }

    @Test
    fun add_test_usingMockito(){
        val calculation = mock(Calculation::class.java)

        `when`(calculation.add(5,5)).thenReturn(9)

        val result = calculation.add(5,5)
        assertEquals(10,result)
    }
}