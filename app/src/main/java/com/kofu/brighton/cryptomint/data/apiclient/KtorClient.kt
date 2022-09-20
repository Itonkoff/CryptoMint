package com.kofu.brighton.cryptomint.data.apiclient

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

private const val TIME_OUT = 60_000

val ktorHttpClient = HttpClient(Android) {

//    install(HttpRequestRetry) {
//        maxRetries = 2
//        retryIf { request, response ->
//            !response.status.isSuccess()
//        }
//        retryOnExceptionIf { request, cause ->
//            cause is NetworkError
//        }
//        delayMillis { retry ->
//            retry * 3000L
//        } // retries in 3, 6, 9, etc. seconds
//    }

    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            encodeDefaults = false
            ignoreUnknownKeys = true
        })
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("ktor_client =>", message)
            }

        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            Log.d("HTTP status:", "${response.status.value}")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}