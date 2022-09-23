package com.kofu.brighton.cryptomint.data

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.kofu.brighton.cryptomint.data.entities.Currency
import com.kofu.brighton.cryptomint.data.room.DAO
import com.kofu.brighton.cryptomint.data.work.ReconcileCurrencyListWorker
import kotlinx.coroutines.flow.Flow

class Repository(dao: DAO, context: Context) {
    var allCurrencies: Flow<List<Currency>> = dao.getAll()

    init {
        val workRequest: WorkRequest =
            OneTimeWorkRequestBuilder<ReconcileCurrencyListWorker>().build()
        WorkManager.getInstance(context).enqueue(workRequest)
    }
}