package com.example.alumperilaapp.ui.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.FragmentAdminBinding

class AdminFragment : Fragment(R.layout.fragment_admin) {
    private lateinit var binding: FragmentAdminBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminBinding.inflate(inflater, container, false)
        return binding.root
    }
}