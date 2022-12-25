package com.krishanshamod.simple_android_application_8.database

import androidx.room.RoomDatabase
import com.krishanshamod.simple_android_application_8.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

abstract class RoomService : RoomDatabase() {

//    abstract fun DatabaseVideoDao(): DatabaseVideoDao

    class Callback @Inject constructor(
        private val database: Provider<RoomService>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()

//    companion object {
//        @Volatile
//        private var INSTANCE: RoomService? = null
//
//        fun getDatabase(context: Context): RoomService {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    RoomService::class.java,
//                    "video_database"
//                ).allowMainThreadQueries().build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }

}