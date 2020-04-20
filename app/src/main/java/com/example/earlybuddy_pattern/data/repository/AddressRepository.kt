package com.example.earlybuddy_pattern.data.repository

import com.example.earlybuddy_pattern.data.datasource.remote.RetrofitRemoteDataSource
import com.example.earlybuddy_pattern.data.datasource.remote.RetrofitRemoteDataSourceImpl

class AddressRepository {
    val RetrofitRemoteDataSource: RetrofitRemoteDataSource = RetrofitRemoteDataSourceImpl()

    fun getAddress(serach: String) = RetrofitRemoteDataSource.getAddress(serach)
}