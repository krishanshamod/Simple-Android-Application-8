package com.krishanshamod.simple_android_application_8.database

import androidx.room.RoomDatabase
import com.krishanshamod.simple_android_application_8.data.main.local.MainDao
import com.krishanshamod.simple_android_application_8.data.main.model.DatabaseVideo
import com.krishanshamod.simple_android_application_8.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@androidx.room.Database(entities = [DatabaseVideo::class], version = 1, exportSchema = false)
abstract class RoomService : RoomDatabase() {

    abstract fun mainDao(): MainDao

    class Callback @Inject constructor(
        private val database: Provider<RoomService>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()

}