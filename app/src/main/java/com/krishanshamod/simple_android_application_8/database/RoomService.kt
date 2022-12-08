package com.krishanshamod.simple_android_application_8.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class RoomService : RoomDatabase() {

    abstract fun DatabaseVideoDao(): DatabaseVideoDao

    companion object {
        @Volatile
        private var INSTANCE: RoomService? = null

        fun getDatabase(context: Context): RoomService {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomService::class.java,
                    "video_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }

}