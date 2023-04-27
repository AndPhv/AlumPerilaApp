package com.example.alumperilaapp.ui.enterPhoneNum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.FragmentEnterPhoneNumBinding

class EnterPhoneNumFragment : Fragment(R.layout.fragment_enter_phone_num) {
    private lateinit var binding: FragmentEnterPhoneNumBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterPhoneNumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.buttonCode.setOnClickListener { sendCode() }
    }

    private fun sendCode() {
        if (binding.editTxtPhoneNum.text.toString().isEmpty()) {
            Toast.makeText(activity, "Введите номер телефона", Toast.LENGTH_SHORT).show()
        } else {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.nav_host_fragment_activity_register, EnterPhoneNumFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}