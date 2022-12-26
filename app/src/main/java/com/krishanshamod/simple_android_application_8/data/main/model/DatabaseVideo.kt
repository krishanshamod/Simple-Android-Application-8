package com.krishanshamod.simple_android_application_8.data.main.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DatabaseVideo")
data class DatabaseVideo(
    @PrimaryKey
    val url: String,
    val title: String,
    val description: String,
    val updated: String,
    val thumbnail: String
)
