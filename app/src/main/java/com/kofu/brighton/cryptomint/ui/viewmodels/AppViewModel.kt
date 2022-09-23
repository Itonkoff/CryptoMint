package com.kofu.brighton.cryptomint.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kofu.brighton.cryptomint.data.Repository
import com.kofu.brighton.cryptomint.data.apiclient.*
import kotlinx.coroutines.launch

class AppViewModel(repository: Repository) : ViewModel() {

    var values = MutableLiveData<LiveValuesResponse>()
    var currencies = MutableLiveData<CurrencyListResponse>()

    fun makeRequest() {
        viewModelScope.launch {
            val vharu: LiveValuesResponse = getLiveValues()
            values.value = vharu
        }
    }

    fun makeAnotherRequest() {
        viewModelScope.launch {
            val kare: CurrencyListResponse = getListOfCurrencies()
            currencies.value = kare
        }
    }
}