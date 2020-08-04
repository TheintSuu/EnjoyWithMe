package com.theintsuhtwe.enjoywithme.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.persistence.typeconverters.CastTypeConverter
import com.theintsuhtwe.enjoywithme.persistence.typeconverters.CrewTypeConverter

@Entity(tableName = "castAndCrew")
@TypeConverters(CastTypeConverter::class, CrewTypeConverter::class)
data class CastAndCrewVO(
    @PrimaryKey
    @SerializedName("id")var id: Int,
    @SerializedName("crew")var crew:ArrayList<CrewVO> = arrayListOf(),
    @SerializedName("cast")var cast: ArrayList<CastVO> = arrayListOf()
) {
}