package com.example.earlybuddy_pattern.ui.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.earlybuddy_pattern.MainActivity
import com.example.earlybuddy_pattern.R
import com.example.earlybuddy_pattern.data.repository.SignUpRepository
import com.example.earlybuddy_pattern.databinding.ActivitySignupBinding
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_signup.*
import org.json.JSONObject
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding

    var vm: SignUpViewModel = SignUpViewModel()

    var SignUpRepository: SignUpRepository = SignUpRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_signup
        )

        getFocus()
        passwordConfirm()

        cl_sign.setOnClickListener {
            closeKeyBoard()
            buttonActive()
        }

        iv_signup.setOnClickListener {
            postUserData(et_id.text.toString(), et_pw.text.toString())
        }
        addObservableData()
    }

    fun addObservableData() {
        vm.isSuccessNetwork.observe(this, Observer {
            when {
                it -> {
                    val intent = Intent(this@SignupActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else -> {
//                    tv_id_red.visibility = View.VISIBLE
//                    et_id.tag = "red"
                }
            }
        })
        vm.wifiDisconnect.observe(this, Observer {
            Toast.makeText(this@SignupActivity, "와이파이 연결을 확인해주세요.", Toast.LENGTH_SHORT).show()
        })
        vm.successUserNum.observe(this, Observer {
            Toast.makeText(this@SignupActivity, "${it} 번쨰로 회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT)
                .show()
        })
        vm.turnRed.observe(this, Observer {
            Toast.makeText(this@SignupActivity, "중복된아이디입니다.", Toast.LENGTH_SHORT)
                .show()
        })
    }

    fun postUserData(id: String, pw: String) {

        //body
        var jsonObject = JSONObject()
        jsonObject.put("userId", id)
        jsonObject.put("userPw", pw)

        val body = JsonParser().parse(jsonObject.toString()) as JsonObject

        vm.signUp(body)

//        SignUpRepository.signUp(body = body, success = {
//            if (it.isSuccessful) {
//                Log.e("result is ", it.body().toString())
//                val signupUser = it.body()!!
//                Toast.makeText(
//                    this@SignupActivity,
//                    "아이디 : ${id}, 비밀번호 : ${pw} ${signupUser.data} 번쨰로 회원가입에 성공하셨습니다.",
//                    Toast.LENGTH_SHORT
//                ).show()
//                val intent = Intent(this@SignupActivity, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                Log.e("fail message ", it.message())
//                tv_id_red.visibility = View.VISIBLE
//                et_id.tag = "red"
//            }
//        }, fail = {
//            Log.e("error is ", it.toString()) })

    }

    private fun getFocus() {
        focusChange(et_id, cl_id)
        focusChange(et_pw, cl_pw)
        focusChange(et_pwc, cl_pwc)
    }

    private fun focusChange(et: EditText, cl: ConstraintLayout) {
        et.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                if (et.tag == "red") {
                    cl.setBackgroundResource(R.drawable.radius_red)
                } else {
                    cl.setBackgroundResource(R.drawable.radius_blue)
                }
            } else {
                cl.setBackgroundResource(R.drawable.radius)
            }
            buttonActive()
        }
    }

    fun EditText.passwordConfirm() {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {

                when (this@passwordConfirm) {
                    et_id -> {
                        tv_id_red.visibility = View.GONE
                        et_id.tag = "blue"
                    }
                    et_pw -> {
                        if (!Pattern.matches("(?=.*[a-z])(?=.*[0-9]).{6,}", text)) {
                            cl_pw.setBackgroundResource(R.drawable.radius_red)
                            tv_pw_red.text = "문자와 숫자를 섞어주세요."
                            tv_pw_red.visibility = View.VISIBLE
                            et_pw.tag = "red"
                            if (text!!.length in 1..5) {
                                cl_pw.setBackgroundResource(R.drawable.radius_red)
                                tv_pw_red.text = "6자 이상 입력해주세요."
                                tv_pw_red.visibility = View.VISIBLE
                                et_pw.tag = "red"
                            }
                        } else {
                            cl_pw.setBackgroundResource(R.drawable.radius_blue)
                            tv_pw_red.visibility = View.GONE
                            et_pw.tag = "blue"
                        }
                        if (text!!.isEmpty()) {
                            cl_pw.setBackgroundResource(R.drawable.radius_blue)
                            tv_pw_red.visibility = View.GONE
                            et_pw.tag = "blue"
                        }
                        if (text.toString() != et_pwc.text.toString()) {
                            tv_pwc_red.visibility = View.VISIBLE
                            et_pwc.tag = "red"
                        } else {
                            tv_pwc_red.visibility = View.GONE
                            et_pwc.tag = "blue"
                        }

                    }
                    et_pwc -> {
                        if (text.toString() == et_pw.text.toString()) {
                            cl_pwc.setBackgroundResource(R.drawable.radius_blue)
                            tv_pwc_red.visibility = View.GONE
                            et_pwc.tag = "blue"
                        } else {
                            cl_pwc.setBackgroundResource(R.drawable.radius_red)
                            tv_pwc_red.visibility = View.VISIBLE
                            et_pwc.tag = "red"
                        }
                    }
                }
            }
        })
    }

    private fun passwordConfirm() {
        et_id.passwordConfirm()
        et_pw.passwordConfirm()
        et_pwc.passwordConfirm()
    }

    private fun buttonActive() {
        if (et_id.text.toString() != "" && et_pw.tag == "blue" && et_pwc.tag == "blue") {
            iv_signup.isClickable = true
            iv_signup.setBackgroundResource(R.drawable.btn_radius_active)
        } else {
            iv_signup.isClickable = false
            iv_signup.setBackgroundResource(R.drawable.btn_radius)
        }
    }

    private fun closeKeyBoard() {
        var view = this.currentFocus

        if (view != null) {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
