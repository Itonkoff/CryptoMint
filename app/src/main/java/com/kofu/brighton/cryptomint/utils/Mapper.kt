package com.kofu.brighton.cryptomint.utils

import com.kofu.brighton.cryptomint.data.apiclient.Datum
import com.kofu.brighton.cryptomint.data.room.entities.CryptoCurrency

fun mapToCryptoCurrency(response: Datum): CryptoCurrency {
    return CryptoCurrency(
        response.id.toInt(),
        response.name,
        response.quote.usd.price,
        response.quote.usd.percentChange1H
    )
}