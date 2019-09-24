package com.anand.myapplication.db.converter

import androidx.room.TypeConverter
import com.anand.myapplication.Recording
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StudentTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun stringToStudent(data: String?): Recording.Student? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<Recording.Student>() {

        }.type

        return gson.fromJson<Recording.Student>(data, listType)
    }

    @TypeConverter
    fun studentToString(student: Recording.Student?): String? {
        return gson.toJson(student)
    }

}