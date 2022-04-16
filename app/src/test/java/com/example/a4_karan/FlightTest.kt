package com.example.a4_karan

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FlightTest{
    @Test
    fun `checking if flight is over 1000km`(){
        val flight = Flight("JFK", "LAX", 3974.20)
        assertThat(flight.cost).isEqualTo(1200.0 + 0.35 * 3974.20)
    }
    @Test
    fun `checking if flight is equal to 1000km`(){
        val flight = Flight("YYZ", "YFC", 1000.0)
        assertThat(flight.cost).isEqualTo(1200.0 + 0.35 * 1000.0)
    }
    @Test
    fun `checking if flight is under 1000km`(){
        val flight = Flight("YYZ", "YUL", 508.0)
        assertThat(flight.cost).isEqualTo(350.0 + 0.75 * 508.0)
    }
}
