package com.example.project.features.splash_activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.project.R
import com.example.project.features.home_activity.HomeActivity
import com.example.project.features.signup_activity.SignUpActivity
import com.example.project.util.SharedPreferences

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            checkUserToken()
        }, SPLASH_SCREEN_DELAY)
    }

    private fun checkUserToken() {
        val user = SharedPreferences.getUser(this)
        val intent = if (user != null && user.token.isNotEmpty()) {
            Intent(this@SplashActivity, HomeActivity::class.java)
        } else {
            Intent(this@SplashActivity, SignUpActivity::class.java)
        }
        startActivity(intent)
        finish()
    }

    companion object {
        private const val SPLASH_SCREEN_DELAY: Long = 1000
    }
}
