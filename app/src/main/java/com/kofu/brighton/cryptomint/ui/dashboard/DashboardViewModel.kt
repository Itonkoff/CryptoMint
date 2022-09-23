package com.kofu.brighton.cryptomint.ui.dashboard

import androidx.lifecycle.*
import com.kofu.brighton.cryptomint.data.Repository
import com.kofu.brighton.cryptomint.ui.viewmodels.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel
@Inject constructor(private val savedStateHandle: SavedStateHandle, repository: Repository) :
    ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    val allcs = repository.allCurrencies.asLiveData()
}


//class DashboardViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return DashboardViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}