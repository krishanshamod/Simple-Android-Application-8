package com.krishanshamod.simple_android_application_8.repository

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.krishanshamod.simple_android_application_8.model.DatabaseVideo

interface DatabaseVideoDao {

    @Query("SELECT * FROM DatabaseVideo")
    fun getVideos(): LiveData<List<DatabaseVideo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(videos: List<DatabaseVideo>)

}