package com.example.alumperilaapp.ui.enterPhoneNum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
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
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterPhoneNumBinding.inflate(inflater, container, false)

//        navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
//        navController = navHostFragment.navController

        binding.buttonCode.setOnClickListener { sendCode() }

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

                fragmentManager?.beginTransaction()
                    ?.replace(R.id.nav_host_fragment_activity_main, EnterCodeFragment(mPhoneNumber, id))
                    ?.addToBackStack(null)
                    ?.commit()

//                val bundle = Bundle()
//                bundle.putString("phoneNumber", mPhoneNumber)
//                bundle.putString("id", id)
//
//                navController.navigate(R.id.navigation_enterCode, bundle, navOptions{launchSingleTop = true
//                    popUpTo(R.id.mobile_navigation)})
            }

        }

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

        val options = PhoneAuthOptions.newBuilder(AUTH)
            .setPhoneNumber(mPhoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(activity as MainActivity)
            .setCallbacks(mCallback)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}