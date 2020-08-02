import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO

data class GetAllMoviesResponse(
//    @SerializedName("page") val code : Int  = 0,
//    @SerializedName("total_results") val totalResult : Int  = 0,
//    @SerializedName("total_pages") val totalPage : Int = 0,
    @SerializedName("results") val data: ArrayList<MoviesVO>? = null
){
    fun isResponseOk() =  (data != null) //&& // (code == 200)
}