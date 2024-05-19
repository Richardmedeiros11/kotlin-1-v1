package br.com.alura.alugames.model

data class Jogo (
    var titulo:String = "",
    var capa:String = "",
){
    var descrição:String? = null
    override fun toString(): String {
        return "Meu br.com.alura.alugames.model.Jogo.br.com.alura.alugames.model.Jogo\n" +
                "Nome: ${titulo}\n" +
                "Capa: ${capa}\n"+
                "Descrição: ${descrição}"
    }
}