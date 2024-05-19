import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner
import com.google.gson.Gson

fun main(){
    print("Digite o ID do jogo > ")
    var input:Scanner = Scanner(System.`in`)
    var input2 = input.nextLine()
    /** O Client é aquele que vai fazer a request.
     * O request é aquilo que o client irá enviar.
     * O response é a junção do client e do request.
     * O Json é o corpo do response.
     */
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=${input2}"))
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

    val meuJogo= Jogo(
            titulo=meuInfoJogo.info.title,
            capa=meuInfoJogo.info.thumb,
        )
    println(meuJogo)
}