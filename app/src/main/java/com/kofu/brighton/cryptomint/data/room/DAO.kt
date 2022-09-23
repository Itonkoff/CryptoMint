package com.kofu.brighton.cryptomint.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kofu.brighton.cryptomint.data.entities.Currency
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {
    @Query("SELECT * FROM currency")
    fun getAll(): Flow<List<Currency>>

    @Query("SELECT * FROM currency")
    fun getAllFrom(): List<Currency>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(currency: Currency)

    @Insert
    suspend fun insertAll(vararg currency: Currency)
}