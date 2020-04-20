package com.example.earlybuddy_pattern.ui.visited

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.earlybuddy_pattern.data.model.Place
import com.example.earlybuddy_pattern.data.repository.AddressRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class VisitedPlaceViewModel : ViewModel() {
    private val addressRepository: AddressRepository = AddressRepository()
    private val disposables = CompositeDisposable()
    val PlaceList = MutableLiveData<List<Place>>()

    fun getAddress(search: String) {
        disposables.add(addressRepository.getAddress(search)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
            }
            .doOnTerminate {}
            .subscribe {
                PlaceList.value = it.message
            }
        )
    }
}