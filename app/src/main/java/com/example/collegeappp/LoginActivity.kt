package com.example.collegeappp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        login.setOnClickListener {
            doLogin()
        }

    }

    private fun doLogin(){
        if (login_email.text.toString().isEmpty()) {
            login_email.error = "Please enter email"
            login_email.requestFocus()
            return
        }


        if (login_password.text.toString().isEmpty()) {
            login_password.error = "Please enter Password"
            login_password.requestFocus()
            return
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(login_email.text.toString()).matches()){
            login_email.error = "Invalid Email Address"
            login_email.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(login_email.text.toString(), login_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.

                    updateUI(null)
                }

            }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {

        if(currentUser != null){
            if(currentUser.isEmailVerified){
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            }else{
                Toast.makeText(baseContext, "Verify Email",
                    Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(baseContext, "Login failed.",
                Toast.LENGTH_SHORT).show()
        }

    }
}