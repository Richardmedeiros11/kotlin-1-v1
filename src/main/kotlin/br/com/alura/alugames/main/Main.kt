package br.com.alura.alugames.main

import br.com.alura.alugames.model.Jogo
import br.com.alura.alugames.services.consumoAPI
import java.util.Scanner
import kotlin.system.exitProcess

fun main(){
    var saida = true
    while (saida) {
        print("Digite o ID do jogo(ou .Exit para sair) > ")
        var input: Scanner = Scanner(System.`in`)
        var id = input.nextLine()
        if (id == ".Exit") {
            saida = false
            exitProcess(0)
        }
        val consumo = consumoAPI()

        val meuInfoJogo = consumo.buscaJogo(id)

        var meuJogo: Jogo? = null
        val resultado = runCatching {
            meuJogo = Jogo(
                meuInfoJogo.info.title,
                meuInfoJogo.info.thumb,
            )
            println(meuJogo)
        }
        resultado.onFailure {
            println("Erro Id inexistente")
        }
        resultado.onSuccess {
            print("Deseja colocar uma descrição? (S/N) > ")
            val descri1 = input.nextLine()
            if (descri1.equals("S", true)) {
                print("Digite a descrição > ")
                val descricao = input.nextLine()
                meuJogo?.descrição = descricao
                println(meuJogo)
            } else {
                println("Ok, Colocaremos a descrição padrão...")
                meuJogo?.descrição = meuJogo?.titulo
                println(meuJogo)
            }
        }
    }
}