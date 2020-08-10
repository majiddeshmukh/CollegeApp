package com.example.collegeappp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val fbutton = findViewById<Button>(R.id.dfill)
            fbutton.setOnClickListener {
                val intent = Intent(this, DataActivity::class.java)
                startActivity(intent)
            }
    }
}