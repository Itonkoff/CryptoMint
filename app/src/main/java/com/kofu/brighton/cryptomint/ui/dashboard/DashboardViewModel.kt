package com.kofu.brighton.cryptomint.ui.dashboard

import androidx.lifecycle.*
import com.kofu.brighton.cryptomint.data.Repository
import com.kofu.brighton.cryptomint.data.room.entities.CryptoCurrency
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel
@Inject constructor(private val savedStateHandle: SavedStateHandle, val repository: Repository) :
    ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }

    lateinit var currency: LiveData<CryptoCurrency>

    val text: LiveData<String> = _text

    fun fetchCurrency(id: Int) {
        currency = repository.getCurrency(id).asLiveData()
    }
}