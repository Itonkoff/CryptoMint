package com.kofu.brighton.cryptomint.data.work

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.kofu.brighton.cryptomint.data.apiclient.getListOfCurrencies
import com.kofu.brighton.cryptomint.data.room.AppDatabase
import com.kofu.brighton.cryptomint.data.room.DAO
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
        val currencies = getListOfCurrencies()
        dao.insert(currencies.crypto.ada)
        dao.insert(currencies.crypto.bch)
        dao.insert(currencies.crypto.bnb)
        dao.insert(currencies.crypto.btc)
        dao.insert(currencies.crypto.doge)
        dao.insert(currencies.crypto.eos)
        dao.insert(currencies.crypto.etc)
        dao.insert(currencies.crypto.eth)
        dao.insert(currencies.crypto.kcs)
        dao.insert(currencies.crypto.leo)
        dao.insert(currencies.crypto.link)
        dao.insert(currencies.crypto.ltc)
        dao.insert(currencies.crypto.mana)
        dao.insert(currencies.crypto.theta)
        dao.insert(currencies.crypto.trx)
        dao.insert(currencies.crypto.usdt)
        dao.insert(currencies.crypto.xlm)
        dao.insert(currencies.crypto.xmr)
        dao.insert(currencies.crypto.xrp)
        dao.insert(currencies.crypto.xtz)
        return Result.success()
    }
}