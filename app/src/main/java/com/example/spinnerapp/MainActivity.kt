package com.example.spinnerapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val data = listOf(

            "Hunter X Hunter",
            "Dragon Ball",
            "Death Note",
            "One Piece",
            "Attack on Titan",
            "One Punch Man",
            "Pokémon",
            "Parasyte: The Maxim",
            "Naruto Shippuden",
            "Jujutsu Kaisen",
            "Bleach",
            "Solo Leveling",
            "Demon Slayer",
            "My Hero Academia",
            "Spirited Away",
            "My Neighbor Totoro",
            "Kiki’s Delivery Service",
            "Ponyo",
            "The Cat Returns",
            "Arrietty",
        )

        val spinner : Spinner = findViewById(R.id.spread_list)

        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,data)

        spinner.adapter= adapter



        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                if (first==0){
                    first =1
                }else{
                    val  intent = Intent(Intent.ACTION_VIEW,"https://www.google.com/search?q=${data[p2]}".toUri())
                    startActivity(intent)
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }



    }
}
