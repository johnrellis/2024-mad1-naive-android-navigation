package com.setu.f1geek.model

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BrandTests {

    @Test
    fun getName() {
        val charles = Car("Charles", "LeClerc", "LEC", 16)
        val carlos = Car("Carlos", "Sainz", "SAI", 55)
        val team = Brand("Ferrari", charles, carlos, mutableListOf())

        assertEquals("Ferrari", team.name)
    }

    @Test
    fun getPrimaryDriver() {
        val charles = Car("Charles", "LeClerc", "LEC", 16)
        val carlos = Car("Carlos", "Sainz", "SAI", 55)
        val team = Brand("Ferrari", charles, carlos, mutableListOf())

        assertEquals(charles, team.primaryDriver)
    }

    @Test
    fun getSecondaryDriver() {
        val charles = Car("Charles", "LeClerc", "LEC", 16)
        val carlos = Car("Carlos", "Sainz", "SAI", 55)
        val team = Brand("Ferrari", charles, carlos, mutableListOf())

        assertEquals(carlos, team.secondaryDriver)
    }

    @Test
    fun setPrimaryAndSecondaryDriverToSameDriver() {
        val charles = Car("Charles", "LeClerc", "LEC", 16)
        assertThrows<IllegalStateException> {
           Brand("Ferrari", charles, charles, mutableListOf())
        }
    }

    @Test
    fun getReserveDrivers() {
        val charles = Car("Charles", "LeClerc", "LEC", 16)
        val carlos = Car("Carlos", "Sainz", "SAI", 55)
        val team = Brand("Ferrari", charles, carlos, mutableListOf())

        assertEquals(team.reserveDrivers, mutableListOf<Car>())
    }
}