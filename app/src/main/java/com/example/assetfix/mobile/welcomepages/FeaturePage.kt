package com.example.assetfix.mobile.welcomepages

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.assetfix.R
import com.example.assetfix.mobile.auth.LogInpage
import com.example.assetfix.mobile.auth.SignUpPage
import com.google.android.material.button.MaterialButton

class FeaturePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_page)
        var logInButton: Button = findViewById(R.id.login)
        logInButton.setOnClickListener {
            openLogInPage()
        }
        var signUpButton: MaterialButton = findViewById(R.id.signup)
        signUpButton.setOnClickListener {
            openSignUpPage()
        }
    }

    private fun openSignUpPage() {
        val intent = Intent(this, SignUpPage::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_to_the_right, R.anim.slide_to_the_left)
    }

    private fun openLogInPage() {
        val intent = Intent(this, LogInpage::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_to_the_right, R.anim.slide_to_the_left)
    }
}