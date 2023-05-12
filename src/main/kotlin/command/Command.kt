package command
interface Command{
    fun execute()
}

class ConcreteCommand(private val receiver: Receiver) : Command{
    override fun execute() {
        receiver.action()
    }
}

class Receiver(){
    fun action(){
        println("получатель выполняет действия")
    }
}

class Initializer(private val command: Command){
    fun executeCommand(){
        command.execute()
    }
}

fun main() {
    val receiver = Receiver()
    val concreteCommand = ConcreteCommand(receiver)
    val initializer = Initializer(concreteCommand)
    initializer.executeCommand()
}
