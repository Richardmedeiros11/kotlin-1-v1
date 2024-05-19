data class Jogo (
    var titulo:String = "",
    var capa:String = "",
){
    override fun toString(): String{
        return "Meu Jogo\n"+
                "Nome: ${titulo}\n"+
                "Capa: ${capa}\n"
    }
}