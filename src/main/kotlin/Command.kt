interface Command {
    fun execute()
}

class ConcreteCommand : Command {
    override fun execute() {
        println("Executing command")
    }
}

class CommandDecorator(private val command: Command) : Command {
    override fun execute() {
        command.execute()
        additionalAction()
    }

    private fun additionalAction() {
        println("Additional action")
    }
}

fun main() {
    val command: Command = ConcreteCommand()
    command.execute()

    val decoratedCommand: Command = CommandDecorator(command)
    decoratedCommand.execute()
}