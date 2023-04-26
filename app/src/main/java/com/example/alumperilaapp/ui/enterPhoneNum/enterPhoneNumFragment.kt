package com.example.alumperilaapp.ui.enterPhoneNum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.FragmentEnterPhoneNumBinding

class enterPhoneNumFragment : Fragment(R.layout.fragment_enter_phone_num) {
    private lateinit var binding: FragmentEnterPhoneNumBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterPhoneNumBinding.inflate(inflater, container, false)
        return binding.root
    }
}