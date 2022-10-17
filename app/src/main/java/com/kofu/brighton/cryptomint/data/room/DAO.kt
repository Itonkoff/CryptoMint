package com.kofu.brighton.cryptomint.data.room

import androidx.room.*
import com.kofu.brighton.cryptomint.data.entities.Currency
import com.kofu.brighton.cryptomint.data.room.entities.CryptoCurrency
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {
    @Query("SELECT * FROM cryptocurrency")
    fun getAllCurrencies(): Flow<List<CryptoCurrency>>

    @Query("SELECT * FROM cryptocurrency")
    fun getList(): List<CryptoCurrency>

    @Query("SELECT * FROM cryptocurrency WHERE id = :id")
    fun getSelectedCurrency(id: Int): Flow<CryptoCurrency>

    @Query("SELECT * FROM cryptocurrency WHERE id = :id")
    fun getCurrency(id: Int): CryptoCurrency

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(currency: CryptoCurrency)

    @Update
    suspend fun update(currency: CryptoCurrency)
//
}