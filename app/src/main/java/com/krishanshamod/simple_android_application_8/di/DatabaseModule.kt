package com.krishanshamod.simple_android_application_8.di

import android.app.Application
import androidx.room.Room
import com.krishanshamod.simple_android_application_8.data.main.local.MainDao
import com.krishanshamod.simple_android_application_8.database.RoomService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: RoomService.Callback) : RoomService {
        return Room.databaseBuilder(application, RoomService::class.java, "video_database")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    @Provides
    @Singleton
    fun provideMainDao(database: RoomService) : MainDao {
        return database.mainDao()
    }

}