package com.rootminusone.omdbapp.com.rootminusone.omdbapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieData::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDataDao() : MovieDataDao

    companion object {
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase? {
            if (INSTANCE == null) {
                synchronized(MovieDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieDatabase::class.java, "moviedata.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}