package com.example.earlybuddy_pattern.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.earlybuddy_pattern.data.model.SignInUser
import com.example.earlybuddy_pattern.data.repository.SignInRepository
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel : ViewModel() {
    val signinRepository = SignInRepository()

    val failedSignIn = MutableLiveData<Throwable>()
    val successedSignIn = MutableLiveData<SignInUser>()

    private val disposables = CompositeDisposable()

    fun signIn(body: JsonObject) {
        disposables.add(signinRepository.signIn(body)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {}
            .doOnTerminate {}
            .subscribe({
                successedSignIn.value = it.data
            }) {
                failedSignIn.value = it
            })
    }

}