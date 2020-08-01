package com.theintsuhtwe.enjoywithme.data.vos


import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class PlayingMoviesVO(

    @SerializedName("id") var id: Int = 0,
    @SerializedName("title") var title: String = "",
    @SerializedName("moview_title") var movieTitle: String = "",
    @SerializedName("poster_path") var posterPath: String = ""
)
