import com.google.gson.annotations.SerializedName

data class InfoApiShark(
    @SerializedName("title") val title:String,
    @SerializedName("thumb") val thumb:String
){
    override fun toString():String{
        return "--Jogo--\n"+
                "Nome: ${title}\n"+
                "Capa: ${thumb}\n"
    }
}
