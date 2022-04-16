package com.example.a4_karan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a4_karan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBookNow.setOnClickListener{
            //check if passport is null or empty and if empty set tvResult to "Sorry, you must provide a passport"
            if(binding.etPassportNum.text.isNullOrEmpty()){
                binding.tvResult.text = "Sorry, you must provide a passport"
            }

            else{
                binding.tvResult.text = "Flight booked!"
                binding.tvReservations.text = "1"
            }
        }
    }
}

