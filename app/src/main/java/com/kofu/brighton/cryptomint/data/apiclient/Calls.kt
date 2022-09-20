package com.kofu.brighton.cryptomint.data.apiclient

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

suspend fun getLiveValues(): LiveValuesResponse = ktorHttpClient.get(HOST) {
    url {
        protocol = URLProtocol.HTTP
        host = HOST
        path("live")
        parameters.append("access_key", ACCESS_KEY)
    }
}.body()

suspend fun getListOfCurrencies(): CurrencyListResponse = ktorHttpClient.get {
    url {
        protocol = URLProtocol.HTTP
        host = HOST
        path("list")
        parameters.append("access_key", ACCESS_KEY)
    }
}.body()
