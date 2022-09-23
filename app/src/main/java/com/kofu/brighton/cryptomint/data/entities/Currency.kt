package com.kofu.brighton.cryptomint.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Currency(
    @PrimaryKey val symbol: String,
    val name: String,

    @SerialName("name_full")
    val nameFull: String,

    @SerialName("max_supply")
    val maxSupply: String,

    @SerialName("icon_url")
    val iconURL: String,

    var rate: Double = 0.0,
    var previousRate: Double = 0.0,
    val numberOfCoins:Double = 0.0
)