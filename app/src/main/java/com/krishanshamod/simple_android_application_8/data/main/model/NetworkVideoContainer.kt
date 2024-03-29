package com.krishanshamod.simple_android_application_8.data.main.model

data class NetworkVideoContainer(
    val videos: List<NetworkVideo>
){
    fun asDomainModel(): List<DevbyteVideo> {
        return videos.map {
            DevbyteVideo(
                title = it.title,
                description = it.description,
                url = it.url,
                updated = it.updated,
                thumbnail = it.thumbnail
            )
        }
    }

    fun asDatabaseModel(): List<DatabaseVideo> {
        return videos.map {
            DatabaseVideo(
                title = it.title,
                description = it.description,
                url = it.url,
                updated = it.updated,
                thumbnail = it.thumbnail
            )
        }
    }
}
