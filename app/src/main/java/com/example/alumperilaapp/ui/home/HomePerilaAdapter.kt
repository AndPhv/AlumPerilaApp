package com.example.alumperilaapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alumperilaapp.R
import com.example.domain.HomePerilaDomain

class HomePerilaAdapter : RecyclerView.Adapter<HomePerilaAdapter.HomePerilaViewHolder>() {

    private var homePerilaList = arrayListOf<HomePerilaDomain>()

    class HomePerilaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPerila: ImageView = itemView.findViewById(R.id.imgPerilaHome)
        val txtPerila: TextView = itemView.findViewById(R.id.txtPerilaHome)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePerilaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.perila_home_item, parent, false)
        return HomePerilaViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomePerilaViewHolder, position: Int) {
        val homePerila = homePerilaList[position]
        holder.imgPerila.setImageResource(homePerila.imgPerila)
        holder.txtPerila.text = homePerila.txtPerila
    }

    override fun getItemCount(): Int {
        return homePerilaList.size
    }

    fun updateHomePerilaList(inputArrayList: List<HomePerilaDomain>) {
        this.homePerilaList.clear()
        notifyItemChanged(1)
        this.homePerilaList.addAll(inputArrayList)
        notifyItemRangeChanged(0, inputArrayList.size)
    }
}