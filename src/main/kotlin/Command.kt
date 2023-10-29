interface Command {
    fun execute()

}
class CommandWrapper() {
    fun go(command: Command) = command.execute()
}

class FootballPlayer(): Command {
    override fun execute() {
        println("Бегу и бью")
    }
}

class BasketballPlayer(): Command {
    override fun execute() {
        println("Прыгаю и кидаю")
    }
}

class ChessPlayer(): Command {
    override fun execute() {
        println("Конь Е5, далее слоном шах, далее пешкой мат")
    }
}

fun main() {
    val commandWrapper = CommandWrapper()
    commandWrapper.go(FootballPlayer())
    commandWrapper.go(BasketballPlayer())
    commandWrapper.go(ChessPlayer())
}