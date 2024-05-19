package br.com.alura.alugames.model

import javax.xml.crypto.Data

data class Gamer(var nome:String, var email:String){

    var usuario:String? = null
    var dataDeNascimento:String? = null
    val idInterno:String? = null

    constructor(nome:String, email: String, usuario:String, dataDeNascimento:String):this(nome, email){
        this.usuario = usuario
        this.dataDeNascimento = dataDeNascimento
    }

    override fun toString():String{
        return "--Gamer--\n"+
                "Nome: ${this.nome}\n"+
                "Email: ${this.email}\n"+
                "Usuario: ${this.usuario}\n"+
                "Data de nascimento: ${this.dataDeNascimento}\n"+
                "Id interno: ${this.idInterno}\n"

    }
}
