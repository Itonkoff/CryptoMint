package com.kofu.brighton.cryptomint.data.room

import androidx.room.*
import com.kofu.brighton.cryptomint.data.entities.Currency
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {
    @Query("SELECT * FROM currency")
    fun getAll(): Flow<List<Currency>>

    @Query("SELECT * FROM currency")
    fun getAllFrom(): List<Currency>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(currency: Currency)

    @Insert
    suspend fun insertAll(vararg currency: Currency)

    @Update
    suspend fun update(currency: Currency)

    @Query("SELECT * FROM currency WHERE symbol = :symbol")
    fun getCurrency(symbol: String): Flow<Currency>
}