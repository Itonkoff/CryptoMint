package com.kofu.brighton.cryptomint.data

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.kofu.brighton.cryptomint.data.room.DAO
import com.kofu.brighton.cryptomint.data.room.entities.CryptoCurrency
import com.kofu.brighton.cryptomint.data.work.ReconcileCurrencyListWorker
import com.kofu.brighton.cryptomint.data.work.ReconcileRatesWorker
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.TimeUnit

class Repository(val dao: DAO, val context: Context) {

    var allCurrencies: Flow<List<CryptoCurrency>> = dao.getAllCurrencies()

    init {
        val listWorker: WorkRequest =
            OneTimeWorkRequestBuilder<ReconcileCurrencyListWorker>().build()


        val ratesWorker: WorkRequest =
            PeriodicWorkRequestBuilder<ReconcileRatesWorker>(1, TimeUnit.MINUTES)
                .build()


        WorkManager.getInstance(context).enqueue(listWorker)
        WorkManager.getInstance(context).enqueue(ratesWorker)
    }

    fun getCurrency(id: Int): Flow<CryptoCurrency> {
        return dao.getSelectedCurrency(id)
    }
}