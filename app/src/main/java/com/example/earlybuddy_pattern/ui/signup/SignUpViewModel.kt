package com.example.earlybuddy_pattern.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.earlybuddy_pattern.data.repository.AddressRepository
import com.example.earlybuddy_pattern.data.repository.SignUpRepository
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class SignUpViewModel : ViewModel() {
    private val SignUpRepository: SignUpRepository = SignUpRepository()
    val isSuccessNetwork = MutableLiveData<Boolean>()
    val turnRed = MutableLiveData<Boolean>()
    val successUserNum = MutableLiveData<Int>()
    val wifiDisconnect = MutableLiveData<Unit>()
    private val disposables = CompositeDisposable()

    fun signUp(body: JsonObject) {

        disposables.add(SignUpRepository.signUp(body)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{}
            .doOnTerminate{}
            .subscribe({
                successUserNum.value = it.data
            }){
                wifiDisconnect.value = Unit
            })


//        SignUpRepository.signUp(body = body, success = {
//            isSuccessNetwork.value = it.isSuccessful
//            if(isSuccessNetwork.value == true){
//                successUserNum.value = it.body()!!.data
//            }else{
//                turnRed.value =true
//            }
//        }, fail = {
//            wifiDisconnect.value = Unit
//        }
//        )
    }

}