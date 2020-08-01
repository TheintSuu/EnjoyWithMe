import com.google.gson.annotations.SerializedName
import com.theintsuhtwe.enjoywithme.data.vos.PlayingMoviesVO

data class GetAllMoviesResponse(
    @SerializedName("code") val code : Int  = 0,
    @SerializedName("message") val message : String = "",
    @SerializedName("data") val data: ArrayList<PlayingMoviesVO>? = null
){
    fun isResponseOk() = (code == 200) && (data != null)
}