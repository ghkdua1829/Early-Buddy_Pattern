package com.example.earlybuddy_pattern.ui.login

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.earlybuddy_pattern.R
import com.example.earlybuddy_pattern.databinding.ActivityLoginBinding
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    var vm: LoginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.actLoginBtnSignIn.setOnClickListener {
            var jsonObject = JSONObject()
            jsonObject.put("userId", binding.actLoginEtId.text)
            jsonObject.put("userPw", binding.actLoginEtPw.text)
            jsonObject.put("deviceToken", "AAA")

            val body = JsonParser().parse(jsonObject.toString()) as JsonObject
            vm.signIn(body)
            Log.e("SAdas", body.toString())
        }
        addobserveData()
    }

    fun addobserveData() {
        vm.successedSignIn.observe(this, Observer {
            Toast.makeText(this@LoginActivity, "${it.userName}님! 로그인에 성공하셨습니다~", Toast.LENGTH_SHORT)
                .show()
        })
        vm.failedSignIn.observe(this, Observer {
            Toast.makeText(this@LoginActivity, it.message, Toast.LENGTH_SHORT).show()
        })
    }
}
