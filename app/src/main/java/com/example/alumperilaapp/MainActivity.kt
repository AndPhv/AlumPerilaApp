package com.example.alumperilaapp

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.alumperilaapp.databinding.ActivityMainBinding

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

        navController.addOnDestinationChangedListener{_,distonation, _ ->
            when(distonation.id) {
                R.id.navigation_catalog -> {
                    supportActionBar?.show()
                }
                R.id.navigation_podrobnee -> {
                    supportActionBar?.show()
                }
                else ->
                    supportActionBar?.hide()
            }
            when(distonation.id) {
                R.id.navigation_home -> {
                    binding.navView.visibility = View.VISIBLE
                }
                R.id.navigation_catalog -> {
                    binding.navView.visibility = View.VISIBLE
                }
                R.id.navigation_account -> {
                    binding.navView.visibility = View.VISIBLE
                }
                else ->
                    binding.navView.visibility = View.GONE
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }
}