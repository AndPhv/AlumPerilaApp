package com.example.alumperilaapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alumperilaapp.R
import com.example.domain.HomeDomain
import com.example.domain.HomePerilaDomain

class HomeViewModel : ViewModel() {

    private val homePerilaList = arrayListOf(
        HomePerilaDomain((R.drawable.perila_home_0), "Круглые перила"),
        HomePerilaDomain((R.drawable.perila_home_1), "Квадратные перила"),
        HomePerilaDomain((R.drawable.perila_home_2), "Покраска под дерево"),
        HomePerilaDomain((R.drawable.perila_home_3), "Плекси перила"),
        HomePerilaDomain((R.drawable.perila_home_4), "Перила со стеклом"),
        HomePerilaDomain((R.drawable.perila_home_5), "Пандусы"),
        HomePerilaDomain((R.drawable.perila_home_6), "Балконы"),
        HomePerilaDomain((R.drawable.perila_home_7), "Схемы сборки")
    )

    private val homePerilaLiveData = MutableLiveData<List<HomePerilaDomain>>()

    fun getHomePerilaLiveData(): LiveData<List<HomePerilaDomain>> = homePerilaLiveData

    init {
        homePerilaLiveData.value = homePerilaList
    }
}