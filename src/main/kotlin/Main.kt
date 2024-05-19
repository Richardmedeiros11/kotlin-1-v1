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
    var uri = "https://www.cheapshark.com/api/1.0/games?id=${input2}"
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
    var meuJogo:Jogo? = null
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
        if(descri1.equals("S", true)){
            print("Digite a descrição > ")
            val descricao = input.nextLine()
             meuJogo?.descrição = descricao
            println(meuJogo)
        }else{
            println("Ok, Colocaremos a descrição padrão...")
            meuJogo?.descrição = meuJogo?.titulo
            println(meuJogo)
        }
    }
}