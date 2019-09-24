package com.anand.myapplication

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recording(
    @PrimaryKey
    @NonNull
    val id: Int,
    val name: String?,
    val start_timestamp: Long,
    val end_timestamp: Long,
    val format: String?,
    val filepath: String,
    val student: Student,
    var isStarred: Boolean = false
) {

    data class Student(
        val id: Int,
        val name: String
    )

}