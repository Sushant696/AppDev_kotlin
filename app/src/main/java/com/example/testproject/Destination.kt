package com.example.testproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testproject.databinding.ActivityDestinationBinding

class Destination : AppCompatActivity() {

    lateinit var binding: ActivityDestinationBinding
    private lateinit var destinationAdapter: DestinationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // variables for the data we want to pass from register activity to destination activity

        val fullName: String = intent.getStringExtra("fullName").toString()
        val email: String = intent.getStringExtra("email").toString()
        val country: String = intent.getStringExtra("country").toString()
        val city: String = intent.getStringExtra("city").toString()
        val gender: String = intent.getStringExtra("gender").toString()

        // showing the received value from these variables
        binding.username.text = "Welcome $fullName ";
        binding.email.text = "Email: $email";
        binding.city.text = "City: $city";
        binding.country.text = "Country: $country"
        binding.gender.text = "Gender: $gender"

        // do your recycler stuff here
        setupRecyclerView()




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun setupRecyclerView() {
        // Prepare lists for RecyclerView
        val imageList = listOf(
            R.drawable.beach,
            R.drawable.banner,
            R.drawable.urbanadv,
            R.drawable.angorie,
            R.drawable._04_1
        )

        val titleList = listOf(
            "Beautiful Beach", "Mountain Retreat", "Urban Adventure","Actor","Error"
        )

        val descriptionList = listOf(
            "Relax on pristine sandy shores",
            "Escape to peaceful mountain landscapes",
            "Explore exciting city experiences",
            "Angorie Rice is an beautiful australian actor",
            "404 Errors are triggered when the server cannot find the resources that user wants."
        )

        // Create and set the adapter
        destinationAdapter = DestinationAdapter(
            this, imageList, titleList, descriptionList
        )

        // Set up RecyclerView
        binding.destinationRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@Destination)
            adapter = destinationAdapter
        }
    }

}