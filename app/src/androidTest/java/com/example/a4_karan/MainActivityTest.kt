package com.example.a4_karan

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Before
    fun setUp() {
        //launch own scenario
    }

    @Test
    fun `testBookWithoutPassport`() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.etName)).perform(typeText("Joe"))
        onView(withId(R.id.etEmail)).perform(typeText("joe@email.com"))
        onView(withId(R.id.btnBookNow)).perform(click())
        //tvResult should display an error that says sorry, you must provide a passport
        onView(withId(R.id.tvResult)).check(matches(withText("Sorry, you must provide a passport")))

    }
    @Test
    fun `testBookWithPassport`(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.etName)).perform(typeText("Joe"))
        onView(withId(R.id.etEmail)).perform(typeText("joe@email.com"))
        onView(withId(R.id.etPassportNum)).perform(typeText("123456789"))
        //check if that tvReservations is 0 to make sure no previous reservations
        onView(withId(R.id.tvReservations)).check(matches(withText("0")))
        onView(withId(R.id.rbJFXLAX)).perform(click())
        onView(withId(R.id.btnBookNow)).perform(click())
        //tvResult should display "Flight booked!"
        onView(withId(R.id.tvResult)).check(matches(withText("Flight booked!")))
        //dtReservations should display "1" after booking
        onView(withId(R.id.tvReservations)).check(matches(withText("1")))
    }
}