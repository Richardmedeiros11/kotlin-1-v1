package br.com.alura.alugames.services

import br.com.alura.alugames.model.InfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class consumoAPI {
    fun buscaJogo(id: String): InfoJogo {
        var uri = "https://www.cheapshark.com/api/1.0/games?id=${id}"

        /** O Client é aquele que vai fazer a request.
         * O request é aquilo que o client irá enviar.
         * O response é a junção do client e do request.
         * O Json é o corpo do response.
         */
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())
        val json = response.body()

        /**
         *  Estanciamos a variavel de refenrencia ao gson
         * */
        val gson = Gson()

        /**
         *  Transformamos o json para uma class
         * */
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        return meuInfoJogo
    }
}