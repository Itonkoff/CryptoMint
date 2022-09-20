package com.kofu.brighton.cryptomint.data.apiclient

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// mend for a url for listing

@Serializable
class LiveValuesResponse(
    val success: Boolean,
    val terms: String,
    val privacy: String,
    val timestamp: Long,
    val target: String,
    val rates: Map<String, Double>
)

@Serializable
data class CurrencyListResponse(
    val success: Boolean,
    val crypto: Crypto,
    val fiat: Map<String, String>
)


@Serializable
data class Crypto(
    @SerialName("BTC")
    val btc: Currency,

    @SerialName("ETH")
    val eth: Currency,

    @SerialName("BNB")
    val bnb: Currency,

    @SerialName("USDT")
    val usdt: Currency,

    @SerialName("XRP")
    val xrp: Currency,

    @SerialName("ADA")
    val ada: Currency,

    @SerialName("DOGE")
    val doge: Currency,

    @SerialName("TRX")
    val trx: Currency,

    @SerialName("LEO")
    val leo: Currency,

    @SerialName("ETC")
    val etc: Currency,

    @SerialName("LTC")
    val ltc: Currency,

    @SerialName("LINK")
    val link: Currency,

    @SerialName("XLM")
    val xlm: Currency,

    @SerialName("XMR")
    val xmr: Currency,

    @SerialName("BCH")
    val bch: Currency,

    @SerialName("XTZ")
    val xtz: Currency,

    @SerialName("MANA")
    val mana: Currency,

    @SerialName("EOS")
    val eos: Currency,

    @SerialName("THETA")
    val theta: Currency,

    @SerialName("KCS")
    val kcs: Currency,
)

@Serializable
data class Currency(
    val symbol: String,
    val name: String,

    @SerialName("name_full")
    val nameFull: String,

    @SerialName("max_supply")
    val maxSupply: String,

    @SerialName("icon_url")
    val iconURL: String
)




