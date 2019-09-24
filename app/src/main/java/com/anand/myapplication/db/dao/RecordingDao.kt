package com.anand.myapplication.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.anand.myapplication.Recording

@Dao
interface RecordingDao {

    @Insert(onConflict = REPLACE)
    fun insert(recording: Recording)

    @Insert(onConflict = REPLACE)
    fun insertAll(recordingList: List<Recording>)

    @Query("SELECT * FROM Recording WHERE id = :id")
    fun get(id: Int): Recording?

    @Query("SELECT * FROM Recording ORDER BY id DESC")
    fun getAll(): List<Recording>?

    @Query("SELECT * FROM Recording ORDER BY id DESC LIMIT :limit OFFSET :offset")
    fun getAllByOffsetAndLimit(offset: Int, limit: Int): List<Recording>?

    @Delete
    fun delete(recording: Recording)

}