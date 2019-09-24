package com.anand.myapplication.db

import android.content.Context
import androidx.room.Room

class DatabaseCreator {

    private var appDatabase: AppDatabase? = null
    private val LOCK = Any()

    private val DB_NAME = "mydb"

    @Synchronized
    fun getAppDatabase(context: Context): AppDatabase {
        if (appDatabase == null) {
            synchronized(LOCK) {
                if (appDatabase == null) {
                    appDatabase = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java, DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
        }
        return appDatabase!!
    }

}