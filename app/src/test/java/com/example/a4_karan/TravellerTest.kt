package com.example.a4_karan

import org.junit.Test
import com.google.common.truth.Truth.assertThat

class TravellerTest{
    @Test
    //Scenario: Traveller books a flight with a passport
    fun `traveller with passport`(){
        val traveller = Traveller("joe","joe@email.com", mutableListOf(), "12345")
        assertThat(traveller.bookFlight(Flight("JFK","LAX",3974.20))).isTrue()
        //check that its added to the traveller list of flights
        assertThat(traveller.bookings).hasSize(1)
        assertThat(traveller.bookings.contains(Flight("JFK","LAX",3974.20)))
    }
    @Test
    //Scenario: Traveller books a flight without a passport
    fun `traveller with no passport`() {
        val traveller = Traveller("joe", "joe@email.com", mutableListOf(), null)
        //do not book the flight if passport is null
        assertThat(traveller.bookFlight(Flight("JFK", "LAX", 3974.20))).isFalse()
        //check that its not added to the traveller list of flights
        assertThat(traveller.bookings).hasSize(0)
    }
    @Test
    fun `traveller with no bookings`(){
        val traveller = Traveller("joe","joe@email.com",  mutableListOf(), "")
        assertThat(traveller.totalCost).isEqualTo(0.0)
        //check that there is no bookings which means total is $0.0
        assertThat(traveller.bookings).hasSize(0)
    }
    @Test
    fun `traveller with one booking`() {
        val traveller = Traveller("joe", "joe@email.com", mutableListOf(), "12345")
        traveller.bookFlight(Flight("JFK", "LAX", 3974.20))
        assertThat(traveller.totalCost).isEqualTo(2590.97)
        //check that there is only 1 booking
        assertThat(traveller.bookings).hasSize(1)
    }
    @Test
    fun `traveller with multiple bookings`() {
        val traveller = Traveller("joe", "joe@email.com", mutableListOf(), "12345")
        traveller.bookFlight(Flight("JFK", "LAX", 3974.20))
        traveller.bookFlight(Flight("YYZ", "YFC", 1000.00))
        traveller.bookFlight(Flight("YYZ", "YUL", 508.0))
        //checks that the total cost is the sum of all flight cost using the pricing in flight
        assertThat(traveller.totalCost).isEqualTo(4871.969999999999)
    }

}