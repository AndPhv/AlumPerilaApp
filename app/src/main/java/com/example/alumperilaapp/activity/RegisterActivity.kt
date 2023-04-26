package com.example.alumperilaapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.ActivityMainBinding
import com.example.alumperilaapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}