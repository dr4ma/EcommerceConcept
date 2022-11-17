package com.example.ecommerceconcept.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.data.utills.CART
import com.example.ecommerceconcept.databinding.ActivityMainBinding
import com.example.ecommerceconcept.databinding.ActivitySplashScreenBinding
import com.example.ecommerceconcept.utills.APP_ACTIVITY_MAIN
import com.example.ecommerceconcept.utills.COUNT_CART
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView
    lateinit var chipNavigationBar: ChipNavigationBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        binding.apply {
            bottomNavigationView = bottomNavHide
            chipNavigationBar = bottomNav
        }
        setContentView(view)

        initNavigation()
        initFields()
    }

    private fun initNavigation(){
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        chipNavigationBar.setOnItemSelectedListener { itemId ->
            bottomNavigationView.selectedItemId = itemId
        }
        chipNavigationBar.setItemSelected(R.id.explorerFragment, true)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        if(COUNT_CART > 0){
            chipNavigationBar.showBadge(R.id.cartFragment, COUNT_CART)
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.cartFragment) {
                chipNavigationBar.visibility = View.GONE
            } else {
                chipNavigationBar.visibility = View.VISIBLE
            }
        }

    }

    private fun initFields(){
        APP_ACTIVITY_MAIN = this
    }

    override fun onBackPressed() {
        super.onBackPressed()
        chipNavigationBar.setItemSelected(bottomNavigationView.selectedItemId, true)
    }
}