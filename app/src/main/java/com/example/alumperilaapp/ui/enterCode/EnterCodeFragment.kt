package com.example.alumperilaapp.ui.enterCode

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.FragmentEnterCodeBinding
import com.example.alumperilaapp.ui.utilits.AppTextWatcher

class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {
    private lateinit var binding: FragmentEnterCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.editTxtCode.addTextChangedListener(AppTextWatcher {
            val string = binding.editTxtCode.text.toString()
            if (string.length >= 6) {
                verifiCode()
            }
        })
    }

    private fun verifiCode() {
        Toast.makeText(requireContext(), "OK", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_enterCodeFragment_to_navigation_home)
    }
}