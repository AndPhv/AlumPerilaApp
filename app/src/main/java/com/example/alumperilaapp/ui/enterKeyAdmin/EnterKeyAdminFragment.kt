package com.example.alumperilaapp.ui.enterKeyAdmin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.FragmentEnterKeyAdminBinding

class EnterKeyAdminFragment : Fragment(R.layout.fragment_enter_key_admin) {
    private lateinit var binding: FragmentEnterKeyAdminBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterKeyAdminBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.buttonKey.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_enterKeyAdminFragment_to_adminFragment)
        }
        binding.txtUser.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_enterKeyAdmin_to_navigation_enterPhoneNum)
        }
    }
}