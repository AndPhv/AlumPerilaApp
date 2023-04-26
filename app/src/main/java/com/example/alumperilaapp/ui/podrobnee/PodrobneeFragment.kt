package com.example.alumperilaapp.ui.podrobnee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.FragmentPodrobneeBinding

class PodrobneeFragment : Fragment(R.layout.fragment_podrobnee) {

    private lateinit var binding: FragmentPodrobneeBinding
    private val vm: PodrobneeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPodrobneeBinding.inflate(inflater, container, false)
        return binding.root
    }
}