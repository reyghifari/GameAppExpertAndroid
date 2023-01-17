package com.hann.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class GameEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "gameId")
    var gameId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "released")
    var released: String,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "playtime")
    var playtime: String,

    @ColumnInfo(name = "background_image")
    var background_image: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
