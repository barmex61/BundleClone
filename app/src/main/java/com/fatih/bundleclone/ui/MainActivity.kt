package com.fatih.bundleclone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.fatih.bundleclone.R
import com.fatih.bundleclone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHosFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_BundleClone_)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        setupNavController()

    }


    private fun setupNavController(){
        navHosFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController=navHosFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}