package com.kofu.brighton.cryptomint.data.apiclient

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse (
    val status: Status,
//    val data: Map<String, Datum>
)

@Serializable
data class Datum (
    val id: Long,
    val name: String,
    val symbol: String,
    val slug: String,

    @SerialName("max_supply")
    val maxSupply: Long? = null,

    val quote: Quote
)

@Serializable
data class Quote (
    @SerialName("USD")
    val usd: Usd
)

@Serializable
data class Usd (
    val price: Double,

    @SerialName("volume_24h")
    val volume24H: Double,

    @SerialName("volume_change_24h")
    val volumeChange24H: Double,

    @SerialName("percent_change_1h")
    val percentChange1H: Double,

    @SerialName("percent_change_24h")
    val percentChange24H: Double,

    @SerialName("percent_change_7d")
    val percentChange7D: Double,

    @SerialName("percent_change_30d")
    val percentChange30D: Double,

    @SerialName("percent_change_60d")
    val percentChange60D: Double,

    @SerialName("percent_change_90d")
    val percentChange90D: Double,

    @SerialName("market_cap")
    val marketCap: Double,

    @SerialName("market_cap_dominance")
    val marketCapDominance: Double,

    @SerialName("fully_diluted_market_cap")
    val fullyDilutedMarketCap: Double,

    @SerialName("last_updated")
    val lastUpdated: String
)

@Serializable
data class Status (
    val timestamp: String,

    @SerialName("error_code")
    val errorCode: Long,

    @SerialName("error_message")
    val errorMessage: String?,

    val elapsed: Long,

    @SerialName("credit_count")
    val creditCount: Long,
)





