package com.example.alumperilaapp.ui.enterKayAdmin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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

        binding.buttonKey.setOnClickListener { sendKey() }
    }

    private fun sendKey() {
        if (binding.editTxtKey.text.toString().isEmpty()) {
            Toast.makeText(requireContext(), "Введите ключ", Toast.LENGTH_SHORT).show()
        } else {
            //authUser()
        }
    }
}