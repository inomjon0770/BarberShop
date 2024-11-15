package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.view.Agendamento
import com.example.myapplication.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.hide()

        binding.btLogin.setOnClickListener {
            val name = binding.editNone.text.toString()

            when{
                name.isEmpty() -> {
                    mensagem(it,"Preencha o horario!")
                }else ->{
                    navegarProHome(name)
                }
            }


            }


        }
    private fun mensagem(view: View, mensagem: String){
        val snackbar = Snackbar.make(view,mensagem,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }
    private fun navegarProHome(name: String){
        val intent = Intent(this, Home::class.java)
        intent.putExtra("name", name)
        startActivity(intent)
    }

    }
