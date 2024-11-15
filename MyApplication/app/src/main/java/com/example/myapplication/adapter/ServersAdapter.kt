 package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.SeviseIteamBinding
import com.example.myapplication.model.Servise

class ServiseAdapter(private val context: Context,private val listServise: MutableList<Servise>):
    RecyclerView.Adapter<ServiseAdapter.ServiseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiseViewHolder {
        val iteamList = SeviseIteamBinding.inflate(LayoutInflater.from(context),parent,false)
        return ServiseViewHolder(iteamList)
    }

    override fun getItemCount() = listServise.size


    override fun onBindViewHolder(holder: ServiseViewHolder, position: Int) {
        holder.imgServise.setImageResource(listServise[position].img!!)
        holder.textServise.text = listServise[position].name
    }



inner class ServiseViewHolder(binding:SeviseIteamBinding): RecyclerView.ViewHolder(binding.root){
    val imgServise = binding.imageSevise
    val textServise = binding.textServise

}
 }




