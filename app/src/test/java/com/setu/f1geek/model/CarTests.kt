package com.setu.f1geek.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTests {

    @Test
    fun getFirstName() {
        val driver = Car("Charles", "LeClerc", "LEC", 16)
        assertEquals("Charles", driver.firstName)
    }

    @Test
    fun getSurname() {
        val driver = Car("Charles", "LeClerc", "LEC", 16)
        assertEquals("LeClerc", driver.surname)
    }

    @Test
    fun getAbbreviatedName() {
        val driver = Car("Charles", "LeClerc", "LEC", 16)
        assertEquals("LEC", driver.abbreviatedName)
    }

    @Test
    fun getNumber() {
        val driver = Car("Charles", "LeClerc", "LEC", 16)
        assertEquals(16, driver.number)
    }
}