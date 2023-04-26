package com.example.alumperilaapp.ui.enterCode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.FragmentEnterCodeBinding

class enterCodeFragment : Fragment(R.layout.fragment_enter_code) {
    private lateinit var binding: FragmentEnterCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterCodeBinding.inflate(inflater, container, false)
        return binding.root
    }
}