package com.kofu.brighton.cryptomint.data.apiclient

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

suspend fun getList(): ApiResponse = ktorHttpClient.get {
    url {
        protocol = URLProtocol.HTTPS
        host = HOST
        appendPathSegments("v1", "cryptocurrency", "quotes", "latest")
        parameters.append("id", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25")
        headers{
            append("X-CMC_PRO_API_KEY", API_KEY)
            append(HttpHeaders.Accept, "application/json")
            append(HttpHeaders.AcceptEncoding, "deflate, gzip")
        }
    }
}.body()
