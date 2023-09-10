package com.example.islami.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islami.R
import com.example.islami.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        StartHomeActivity()
    }

    private fun StartHomeActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        },2000)
    }
}