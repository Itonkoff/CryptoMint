package com.kofu.brighton.cryptomint.ui.home

import androidx.lifecycle.*
import com.kofu.brighton.cryptomint.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(private val savedStateHandle: SavedStateHandle,val repository: Repository) :
    ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text

    val currencies = repository.allCurrencies.asLiveData()

    fun reconcileRates() {
repository.reconcileRates()
    }
}