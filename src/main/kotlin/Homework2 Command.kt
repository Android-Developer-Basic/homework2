interface Command {
    fun execute()
}
class Alfavit {
    fun firstlit() {
        println("А")
    }
    fun secondlit() {
        println("Б")
    }
    fun thirdlit() {
        println("В")
    }

}
class FirstLit(private val string: Alfavit) : Command {
    override fun execute() {
        string.firstlit()
    }
}
class SecondLit(private val string: Alfavit) : Command {
    override fun execute() {
        string.secondlit()
    }

}
class ThirdLit(private val string: Alfavit) : Command {
    override fun execute() {
        string.thirdlit()
    }
class Invoker (var command: Command) {
    fun doExecute() {
        command.execute()
    }
}
fun main() {
    val alfavit = Alfavit()
    val firstLit = FirstLit(alfavit)
    val secondLit = SecondLit(alfavit)
    val thirdLit = ThirdLit(alfavit)
    val invoker = Invoker(firstLit)
    invoker.doExecute()
    invoker.command = secondLit
    invoker.doExecute()
    invoker.command = thirdLit
    invoker.doExecute()

}
}
