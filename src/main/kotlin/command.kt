interface Command<T> {
    fun execute()
    fun cancel()
    fun name(): String
}

class Shell {
    fun <T> launch(c: Command<T>) = c.execute()
}

class SumNumbersCommand(private vararg val args: Double?) : Command<Double> {
    override fun execute() = println(args.filterNotNull().sum())

    override fun cancel() = TODO("Not yet implemented")

    override fun name(): String = "sum"
}

class SortNumbersCommand(private vararg val args: Int?) : Command<Int> {
    override fun execute() = println(args.filterNotNull().sorted())

    override fun cancel() = TODO("Not yet implemented")

    override fun name(): String = "sort"
}

fun main() {
    val shell = Shell()
    shell.launch(SumNumbersCommand(2.5, 3.5, 8.4))
    shell.launch(SortNumbersCommand(3, 1, 2))
}