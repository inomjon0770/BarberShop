package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.ServiseAdapter
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.model.Servise

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var serviseAdapter: ServiseAdapter
    private val listServise: MutableList<Servise> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.extras?.getString("name")


        supportActionBar?.hide()
        binding.textNameUser.text = "Xush kelibsiz,$name"
        val recyclerViewServise = binding.recyclerViewSevise
        recyclerViewServise.layoutManager = GridLayoutManager(this, 2)
        serviseAdapter =  ServiseAdapter(this,listServise)
        recyclerViewServise.setHasFixedSize(true)
        recyclerViewServise.adapter = serviseAdapter
        getServise()

        binding.Bronqilish.setOnClickListener {
            intent = Intent(this, Agendamento::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }

    }
    private fun getServise() {

        val servise1 = Servise(R.drawable.img1,"Soch kesish")
        listServise.add(servise1)

        val servise2 = Servise(R.drawable.img2,"Soqol olish")
        listServise.add(servise2)

        val servise3 = Servise(R.drawable.img3,"Soch yuvish")
        listServise.add(servise3)

        val servise4 = Servise(R.drawable.img4,"Sochni davolash")
        listServise.add(servise4)

    }



}







