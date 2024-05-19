package br.com.alura.alugames.model

import com.google.gson.annotations.SerializedName

data class InfoApiShark(
    @SerializedName("title") val title:String,
    @SerializedName("thumb") val thumb:String
){
    override fun toString():String{
        return "--br.com.alura.alugames.model.Jogo.br.com.alura.alugames.model.Jogo--\n"+
                "Nome: ${title}\n"+
                "Capa: ${thumb}\n"
    }
}
