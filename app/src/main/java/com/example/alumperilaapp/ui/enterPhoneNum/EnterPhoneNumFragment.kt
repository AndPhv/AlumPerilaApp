package com.example.alumperilaapp.ui.enterPhoneNum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.alumperilaapp.MainActivity
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.FragmentEnterPhoneNumBinding
import com.example.alumperilaapp.ui.enterCode.EnterCodeFragment
import com.example.alumperilaapp.ui.utilits.AUTH
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class EnterPhoneNumFragment : Fragment(R.layout.fragment_enter_phone_num) {

    private lateinit var binding: FragmentEnterPhoneNumBinding
    private lateinit var mPhoneNumber: String
    private lateinit var mCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    //private lateinit var navController: NavController

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
        mCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(requireContext(), "OK", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_navigation_enterPhoneNum_to_enterCodeFragment)
                    } else Toast.makeText(requireContext(), task.exception?.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(requireContext(), p0.message.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
//                navController.navigate(R.id.navigation_enterCode, bundleOf(), navOptions{launchSingleTop = true
//                    popUpTo(R.id.mobile_navigation)})

                fragmentManager?.beginTransaction()
                    ?.replace(R.id.nav_host_fragment_activity_main, EnterCodeFragment(mPhoneNumber, id))
                    ?.addToBackStack(null)
                    ?.commit()
            }

        }
        binding.buttonCode.setOnClickListener { sendCode() }
    }

    private fun sendCode() {
        if (binding.editTxtPhoneNum.text.toString().isEmpty()) {
            Toast.makeText(requireContext(), "Введите номер телефона", Toast.LENGTH_SHORT).show()
        } else {
            authUser()
        }
    }

    private fun authUser() {
        mPhoneNumber = binding.editTxtPhoneNum.text.toString()
        //PhoneAuthProvider.getInstance().verifyPhoneNumber(mPhoneNumber, 60, TimeUnit.SECONDS, activity as MainActivity, mCallback)

        val options = PhoneAuthOptions.newBuilder(AUTH)
            .setPhoneNumber(mPhoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(activity as MainActivity)
            .setCallbacks(mCallback)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}