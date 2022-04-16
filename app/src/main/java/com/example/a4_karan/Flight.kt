package com.example.a4_karan

class Flight(  var departingAirport : String? = null, var arrivingAirport : String? = null, var distance : Double? = null, ) {
    val cost : Double
        get() {
            if (distance!! >= 1000) {
                return 1200 + 0.35 * distance!!
            } else {
                return 350 + 0.75 * distance!!
            }
        }
}