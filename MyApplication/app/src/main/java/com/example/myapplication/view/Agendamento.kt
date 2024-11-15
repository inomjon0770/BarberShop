package com.example.myapplication.view

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.myapplication.databinding.ActivityAgendamentoBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class Agendamento : AppCompatActivity() {
    private lateinit var binding: ActivityAgendamentoBinding
    private val calendar: Calendar = Calendar.getInstance()
    private var data: String = ""
    private var time: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAgendamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val name = intent.extras?.getString("name").toString()

        val dataPicker = binding.DataPicker

        dataPicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            var dia = dayOfMonth.toString()
            val mes: String

            if (dayOfMonth < 10) {
                dia = "0$dayOfMonth"
            }
            if (monthOfYear < 10) {
                mes = "" + (monthOfYear + 1)
            } else {
                mes = (monthOfYear + 1).toString()
            }
            data = "$dia / $mes / $year"
        }
        binding.TimePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
            val minuto: String
            if (minute > 10) {
                minuto = "0$minute"
            } else {
                minuto = minute.toString()
            }
            time = "$hourOfDay:$minuto"
        }
        binding.TimePicker.setIs24HourView(true)
        binding.Royhatgaolish.setOnClickListener {
            val barber1 = binding.barber1
            val barber2 = binding.barber2
            val barber3 = binding.barber3
            when {
                time.isEmpty() -> {
                    mensagem(it, "preencha o horario!", "#FF0000")

                }

                time < "8:00" && time > "19:00" -> {
                    mensagem(
                        it,
                        "Barber shop esta fechado - horario de atendimento das 08:00 as 19:00!",
                        "#FF0000"
                    )

                }

                data.isEmpty() -> {
                    mensagem(it, "Coloque uma data!", "#FF0000")

                }

                barber1.isChecked && data.isNotEmpty() && time.isNotEmpty() -> {
                    mensagem(it, "Agendamento realizado com sucesso!", "#FF03DAC5")

                }

                barber2.isChecked && data.isNotEmpty() && time.isNotEmpty() -> {
                    mensagem(it, "Agendamento realizado com sucesso!", "#FF03DAC5")

                }

                barber3.isChecked && data.isNotEmpty() && time.isNotEmpty() -> {
                    mensagem(it, "Agendamento realizado com sucesso!", "#FF03DAC5")

                }

                else -> {
                    mensagem(it, "Escolha um barbeiro!", "#FF0000")
                }
            }
        }
    }

    private fun mensagem(view: View, mensage: String, cor: String) {
        val snackbar = Snackbar.make(view, mensage, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor(cor))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }
}