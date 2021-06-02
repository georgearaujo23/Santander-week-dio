package com.inspera.santanderweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inspera.santanderweek.data.Conta
import com.inspera.santanderweek.data.local.FakeData

class MainViewModel : ViewModel() {
    private val mutableLiveData : MutableLiveData<Conta>  = MutableLiveData()

    fun buscarContaCliente() : LiveData<Conta>{
        mutableLiveData.value = FakeData().getLocalDate()

        return mutableLiveData
    }

}