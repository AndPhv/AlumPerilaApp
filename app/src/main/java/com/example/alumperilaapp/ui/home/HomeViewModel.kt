package com.example.alumperilaapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alumperilaapp.R
import com.example.domain.HomeDomain

class HomeViewModel : ViewModel() {

    private val homeList = arrayListOf(
        HomeDomain(R.drawable.image1),
        HomeDomain(R.drawable.image2),
        HomeDomain(R.drawable.image3),
        HomeDomain(R.drawable.image4),
        HomeDomain(R.drawable.image5)
    )

    private val homeLiveData = MutableLiveData<List<HomeDomain>>()

    fun getHomeLiveData(): LiveData<List<HomeDomain>> = homeLiveData

    init {
        homeLiveData.value = homeList
    }
}