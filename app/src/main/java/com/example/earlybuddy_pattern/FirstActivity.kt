package com.example.earlybuddy_pattern

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.earlybuddy_pattern.databinding.ActivityFirstBinding
import com.example.earlybuddy_pattern.ui.login.LoginActivity
import com.example.earlybuddy_pattern.ui.signup.SignupActivity
import com.example.earlybuddy_pattern.ui.visited.VisitedPlaceActivity

class FirstActivity : AppCompatActivity() {

    lateinit var binding: ActivityFirstBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_first
        )

        btnClick()

    }

    fun btnClick() {
        binding.signUp.setOnClickListener {
            val intent = Intent(this@FirstActivity, SignupActivity::class.java)
            startActivity(intent)
        }

        binding.visitedPlace.setOnClickListener {
            val intent = Intent(this@FirstActivity, VisitedPlaceActivity::class.java)
            startActivity(intent)
        }

        binding.signIn.setOnClickListener {
            val intent = Intent(this@FirstActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}