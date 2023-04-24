package com.example.alumperilaapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.alumperilaapp.R
import com.example.domain.HomeDomain

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var homeList = arrayListOf<HomeDomain>()

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val perilaImageView: ImageView = itemView.findViewById(R.id.imgPerila)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.img_home_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val home = homeList[position]
        holder.perilaImageView.setImageResource(home.imagePerila)
    }

    override fun getItemCount(): Int {
        return homeList.size
    }

    fun updateHomeList(inputArrayList: List<HomeDomain>) {
        this.homeList.clear()
        notifyItemChanged(1)
        this.homeList.addAll(inputArrayList)
        notifyItemRangeChanged(0, inputArrayList.size)
    }


}