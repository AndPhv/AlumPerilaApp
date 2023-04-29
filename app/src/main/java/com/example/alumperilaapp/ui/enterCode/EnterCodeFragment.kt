package com.example.alumperilaapp.ui.enterCode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alumperilaapp.MainActivity
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.FragmentEnterCodeBinding
import com.example.alumperilaapp.ui.utilits.AUTH
import com.example.alumperilaapp.ui.utilits.AppTextWatcher
import com.google.firebase.auth.PhoneAuthProvider

class EnterCodeFragment( val phoneNumber: String, val id: String) : Fragment(R.layout.fragment_enter_code) {

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
        (activity as MainActivity).title = phoneNumber
        binding.editTxtCode.addTextChangedListener(AppTextWatcher {
            val string = binding.editTxtCode.text.toString()
            if (string.length >= 6) {
                enterCode()
            }
        })
    }

    private fun enterCode() {
        val code = binding.editTxtCode.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(requireContext(), "OK", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_navigation_enterPhoneNum_to_enterCodeFragment)
            } else Toast.makeText(requireContext(), task.exception?.message.toString(), Toast.LENGTH_SHORT).show()
        }

        //findNavController().navigate(R.id.action_enterCodeFragment_to_navigation_home)
    }
}