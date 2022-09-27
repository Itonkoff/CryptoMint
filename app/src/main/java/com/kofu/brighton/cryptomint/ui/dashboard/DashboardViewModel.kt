package com.kofu.brighton.cryptomint.ui.dashboard

import androidx.lifecycle.*
import com.kofu.brighton.cryptomint.data.Repository
import com.kofu.brighton.cryptomint.data.entities.Currency
import com.kofu.brighton.cryptomint.ui.viewmodels.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel
@Inject constructor(private val savedStateHandle: SavedStateHandle, val repository: Repository) :
    ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }

    lateinit var currency: LiveData<Currency>

    val text: LiveData<String> = _text

    fun fetchCurrency(symbol: String) {
        currency = repository.getCurrency(symbol).asLiveData()
    }
}