package com.example.alumperilaapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.alumperilaapp.databinding.ActivityMainBinding
import com.example.alumperilaapp.ui.utilits.AUTH
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController

        setSupportActionBar(binding.toolbar)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_catalog, R.id.navigation_home, R.id.navigation_account
            )
        )

        binding.toolbar.setNavigationOnClickListener {
            navController.popBackStack()
        }

//        binding.toolbar.navigationIcon?.setTint(Color.parseColor("#FFFFFF"))

        navController.addOnDestinationChangedListener{_,distonation, _ ->
            when(distonation.id) {
                R.id.navigation_catalog, R.id.navigation_podrobnee -> {
                    supportActionBar?.show()
                }
                else ->
                    supportActionBar?.hide()
            }

            when(distonation.id) {
                R.id.navigation_home, R.id.navigation_catalog, R.id.navigation_account -> {
                    binding.navView.visibility = View.VISIBLE
                }
                else ->
                    binding.navView.visibility = View.GONE
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if (AUTH.currentUser != null) {
            navController.navigate(R.id.navigation_home, bundleOf(), navOptions{launchSingleTop = true
                popUpTo(R.id.mobile_navigation)})
        } else {
            navController.navigate(R.id.navigation_enterPhoneNum, bundleOf(), navOptions{launchSingleTop = true
                popUpTo(R.id.mobile_navigation)})
        }
    }

    private fun initFields() {
        AUTH = FirebaseAuth.getInstance()
    }
}