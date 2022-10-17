package com.kofu.brighton.cryptomint.data.work

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.kofu.brighton.cryptomint.data.apiclient.getList
import com.kofu.brighton.cryptomint.data.room.DAO
import com.kofu.brighton.cryptomint.utils.mapToCryptoCurrency
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class ReconcileCurrencyListWorker
@AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted params: WorkerParameters,
    val dao: DAO
) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val list = dao.getList()
        if (list.size != 25) {
            val currencies = getList()
//            for (currency in currencies.data) {
//                dao.insert(mapToCryptoCurrency(currency.value))
//            }
        }
        return Result.success()
    }
}