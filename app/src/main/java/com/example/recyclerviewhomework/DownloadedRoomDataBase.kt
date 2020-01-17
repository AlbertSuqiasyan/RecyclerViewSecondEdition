package com.example.recyclerviewhomework

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DownloadedData::class], version = 1, exportSchema = false)
abstract class DownloadedRoomDataBase : RoomDatabase() {

    abstract val downloadedDataDao: DownloadedDataDao

    companion object {

        @Volatile
        private var INSTANCE: DownloadedRoomDataBase? = null

        fun getInstance(context: Context): DownloadedRoomDataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DownloadedRoomDataBase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}