package com.example.collegeappp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class DataActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var year: EditText
    lateinit var dept: EditText
    lateinit var rno: EditText
    lateinit var sub: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        name = findViewById(R.id.dataname)
        year = findViewById(R.id.datayear)
        dept = findViewById(R.id.datadept)
        rno = findViewById(R.id.datarno)
        sub = findViewById(R.id.datasubmit)

        sub.setOnClickListener {
            saveData()
        }

    }

    private fun saveData(){
        val sname = name.text.toString().trim()
        val syear = year.text.toString().trim()
        val sdept = dept.text.toString().trim()
        val srn = rno.text.toString().trim()
        val srno = Integer.parseInt(srn)

        if(sname.isEmpty()){
            name.error = "Please enter a name"
            return
        }

        if(syear.isEmpty()){
            year.error = "Please enter a year"
            return
        }
        if(sdept.isEmpty()){
            dept.error = "Please enter a name"
            return
        }


        val ref = FirebaseDatabase.getInstance().getReference("Data")
        val dataId = ref.push().key!!

        val data = Data(dataId, sname, syear, sdept, srno)

        ref.child(dataId).setValue(data).addOnCompleteListener {
            Toast.makeText(applicationContext, "Data Saved Successfully", Toast.LENGTH_LONG).show()
        }

    }

}