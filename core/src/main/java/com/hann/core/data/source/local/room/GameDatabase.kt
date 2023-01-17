package com.hann.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hann.core.data.source.local.entity.GameEntity
import com.hann.core.domain.model.Game

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

}