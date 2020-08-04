package com.theintsuhtwe.enjoywithme.network.response

import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.data.vos.NowPlayingVO

class GetAllNowPlayingMoviesResponse(
//    @SerializedName("page") val code : Int  = 0,
//    @SerializedName("total_results") val totalResult : Int  = 0,
//    @SerializedName("total_pages") val totalPage : Int = 0,
    @SerializedName("results") val data: ArrayList<NowPlayingVO> = arrayListOf()
){
    fun isResponseOk() =  (data != null)// &&  (code == 200)
}