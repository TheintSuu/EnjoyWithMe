package com.theintsuhtwe.enjoywithme.data.vos


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class MoviesVO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id") var id: Int = 0,
    @ColumnInfo(name ="original_title") var originalTitle: String = "",
    @ColumnInfo(name ="backdrop_path") var backdropPath: String = "",
    @ColumnInfo(name ="title") var title: String = "",
    @ColumnInfo(name ="moview_title") var movieTitle: String = "",
    @ColumnInfo(name ="poster_path") var posterPath: String = "",
    @ColumnInfo(name ="popularity") var popularity: Double = 0.0,
    @ColumnInfo(name ="vote_count") var vote_count: Int = 0,
    @ColumnInfo(name ="video") var videoStatus: Boolean = false,
    @ColumnInfo(name ="adult") var adultStatus: Boolean = false,
    @ColumnInfo(name ="media_type") var mediaType: String = "",
    @ColumnInfo(name ="vote_average") var voteAvagere: Double = 0.0,
    @ColumnInfo(name ="overview") var overView: String = "",
    @ColumnInfo(name ="release_date") var releaseDate: String = "",
    @ColumnInfo(name ="first_air_date") var firstAirDate: String = "",
    @ColumnInfo(name ="original_language") var original_language: String = "",
    @ColumnInfo(name ="genre_ids")  var vargenre_ids: ArrayList<Int> = arrayListOf<Int>(),
    @ColumnInfo(name ="name")  var name : String = "",
    @ColumnInfo(name ="original_name")  var originalName : String = ""

)


