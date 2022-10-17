package com.kofu.brighton.cryptomint.utils

import com.kofu.brighton.cryptomint.data.entities.Currency

object CurrencyAnalysis {
    lateinit var currency: Currency
    var winLossPercentage = 0.0
    var totalValue = 0.0

    fun calculate(selected: Currency) {
        currency = selected
        winLossPercentage = ((currency.rate - currency.previousRate) / currency.rate) * 100
        totalValue = currency.rate * currency.numberOfCoins
        // todo add results for construction of strings snd use those strings in DashFragment and Adapter
    }
}