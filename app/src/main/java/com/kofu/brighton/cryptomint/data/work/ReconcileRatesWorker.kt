package com.kofu.brighton.cryptomint.data.work

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.kofu.brighton.cryptomint.data.apiclient.getLiveValues
import com.kofu.brighton.cryptomint.data.room.DAO
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class ReconcileRatesWorker
@AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted params: WorkerParameters,
    val dao: DAO
) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val liveValues = getLiveValues()
        val list = dao.getAllFrom()

        for (currency in list){
            val rate = liveValues.rates[currency.symbol]
            if (rate!=null) {
                currency.previousRate = currency.rate
                currency.rate = rate
            }

            dao.update(currency)
        }

        return Result.success()
    }
}