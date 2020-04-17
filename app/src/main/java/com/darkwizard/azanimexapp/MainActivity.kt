package com.darkwizard.azanimexapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //fun getTypeFace() : Typeface =Typeface.createFromAsset(assets,"fonts/orbitron_medium.ttf")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //textLogo.typeface = getTypeFace()
        //textSlogan.typeface = getTypeFace()
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_inicio,R.id.navigation_pelicullas,
            R.id.navigation_onas,R.id.navigation_ovas,
            R.id.navigation_especiales
        ))
        val navController = NavController(this)
        setupBottonNavMenu(navController)
    }

    private fun setupBottonNavMenu(navController : NavController){
        val bottomNav = findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNav?.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }
}
