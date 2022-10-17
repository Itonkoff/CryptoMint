package com.kofu.brighton.cryptomint.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CryptoCurrency(
    @PrimaryKey val id: Int,
    val name: String,
    val price: Double,
    var percentChange: Double,
    val numberOfCoins:Double = 0.0
)