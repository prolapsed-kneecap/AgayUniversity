package com.polich.kneecap

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_NOSENSOR

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp() = navController.navigateUp() || super.onSupportNavigateUp()

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_app_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    interface OnBackPressedListener {
        fun onBackPressed()
    }

    override fun onBackPressed() {
        val fm: FragmentManager = supportFragmentManager
        var backPressedListener: OnBackPressedListener? = null
        for (fragment in fm.getFragments()) {
            if (fragment is OnBackPressedListener) {
                backPressedListener = fragment
                break
            }
        }
        if (backPressedListener != null) {
            backPressedListener.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }
}