package com.example.a4_karan

class Traveller (val name: String, val email: String, val bookings: MutableList<Flight>, val passport: String?) {

    fun bookFlight(flight: Flight): Boolean {
        if (passport != null) {
            bookings.add(flight)
            return true
        }
        return false
    }

    val totalCost: Double
        get() {
            var total = 0.0
            for (booking in bookings) {
                total += booking.cost
            }
            return total
        }

}