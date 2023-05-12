package singleton

class GameConfig private constructor(){
    private var heroPull : Int = 124;
    private var latency: Int = 500;
    private var waitingPlayers: Int = 0;
    private var matchName: String = "default"

    companion object {
        val instance : GameConfig by lazy { GameConfig() }
    }

    fun addPlayers(int: Int){
        this.waitingPlayers +=int
    }
    fun printConfig(){
        println("$matchName $heroPull $latency $waitingPlayers")
    }
}

fun main(){
    val config = GameConfig.instance
    val anotherConfig = GameConfig.instance
    anotherConfig.addPlayers(23)
    config.addPlayers(23)

    config.printConfig()

}