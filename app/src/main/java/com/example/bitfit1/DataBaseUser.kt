package com.example.bitfit1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class DataBaseUser: RoomDatabase() {

    abstract fun UserDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: DataBaseUser? = null

        fun getInstance(context: DaoApplication): DataBaseUser =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }


        private fun buildDatabase(context: DaoApplication) =
            Room.databaseBuilder(
                context.applicationContext,
                DataBaseUser::class.java, "Articles-db"
            ).build()
    }
}