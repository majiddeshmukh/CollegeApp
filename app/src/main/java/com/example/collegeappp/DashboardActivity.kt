package com.example.collegeappp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment
    lateinit var assFragment: AssFragment
    lateinit var vidFragment: VidFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

//        val fbutton = findViewById<Button>(R.id.dfill)
//            fbutton.setOnClickListener {
//                val intent = Intent(this, DataActivity::class.java)
//                startActivity(intent)
//            }

        val bottomNav : BottomNavigationView = findViewById(R.id.navbar)

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()


        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.navhome -> {

                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.framelayout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }

                R.id.navass -> {

                    assFragment = AssFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.framelayout, assFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }

                R.id.navvid -> {

                    vidFragment = VidFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.framelayout, vidFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }

            }
            true
        }

    }
}