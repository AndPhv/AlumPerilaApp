package com.example.alumperilaapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alumperilaapp.R
import com.example.domain.HomeONasDomain

class HomeONasAdapter(private val homeONasClickListener: HomeONasClickListener) : RecyclerView.Adapter<HomeONasAdapter.HomeONasViewHolder>() {

    private var homeONasList = arrayListOf<HomeONasDomain>()

    interface HomeONasClickListener {
        fun onClick(command: Int)
    }

    class HomeONasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgONas: ImageView = itemView.findViewById(R.id.imgONasHome)
        val txtONas: TextView = itemView.findViewById(R.id.txtONasHome)
        val linLayoutONas: LinearLayout = itemView.findViewById(R.id.linLayoutONas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeONasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.o_nas_home_item, parent, false)
        return HomeONasViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeONasViewHolder, position: Int) {
        val homeONas = homeONasList[position]
        holder.imgONas.setImageResource(homeONas.imgONas)
        holder.txtONas.text = homeONas.txtONas
        holder.linLayoutONas.setOnClickListener {
            homeONasClickListener.onClick(R.layout.fragment_podrobnee)
        }
    }

    override fun getItemCount(): Int {
        return homeONasList.size
    }

    fun updateHomeONasList(inputArrayList: List<HomeONasDomain>) {
        this.homeONasList.clear()
        notifyItemChanged(1)
        this.homeONasList.addAll(inputArrayList)
        notifyItemRangeChanged(0, inputArrayList.size)
    }
}