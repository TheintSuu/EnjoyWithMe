package com.theintsuhtwe.enjoywithme.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.theintsuhtwe.enjoywithme.data.vos.CrewVO

class CrewTypeConverter {
    @TypeConverter
    fun toString(commentList: ArrayList<CrewVO>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<CrewVO> {
        val commentListType = object : TypeToken<ArrayList<CrewVO>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}