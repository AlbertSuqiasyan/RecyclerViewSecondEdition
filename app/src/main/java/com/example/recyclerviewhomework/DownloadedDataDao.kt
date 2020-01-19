package com.example.recyclerviewhomework

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DownloadedDataDao{
    @Insert
    fun insert(result:Result)

    @Update
    fun update(result: Result)

    @Query("SELECT * from result_table WHERE id = :key")
    fun get(key: String): Result?

    @Query("SELECT * FROM result_table ORDER BY id DESC LIMIT 1")
    fun getResult(): Result?
}