package com.example.collegeappp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_convert.*

class ConvertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)

        convert.setOnClickListener {
            convertcgpa()

        }


    }

    private fun convertcgpa(){
        val cgp = cgpa.text.toString().toFloat()
        val ccg = cgpa.text.toString().trim()

        if (cgp<7 && cgp>0){
            val resultt = ((7.1*cgp)+12).toString()
            cresult.text = resultt + "%"
        }

        else if (cgp>=7 && cgp<=10){
            val resultt = ((7.4*cgp)+12).toString()
            cresult.text = resultt + "%"
        }

        else{
            cgpa.error="Enter Valid CGPA"
            cgpa.requestFocus()
            return
        }

    }
}