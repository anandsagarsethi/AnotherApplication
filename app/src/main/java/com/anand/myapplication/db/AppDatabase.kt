package com.anand.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.anand.myapplication.Recording
import com.anand.myapplication.db.converter.StudentTypeConverter
import com.anand.myapplication.db.dao.RecordingDao

@Database(entities = [Recording::class], version = 3)
@TypeConverters(StudentTypeConverter::class)
abstract class AppDatabase: RoomDatabase() {

        abstract fun recordingDao(): RecordingDao

}