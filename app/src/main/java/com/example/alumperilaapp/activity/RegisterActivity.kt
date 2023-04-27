package com.example.alumperilaapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.ActivityRegisterBinding
import com.example.alumperilaapp.ui.home.HomeFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_fragment_activity_register,
                HomeFragment()
            ).commit()
    }
}