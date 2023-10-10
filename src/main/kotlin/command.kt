interface Command<T> {
    fun execute(vararg args: T?)
    fun cancel()
    fun name(): String
}

class Shell {
    fun <T> launch(c: Command<T>, vararg args: T?) = c.execute(*args)
}

class SumNumbersCommand : Command<Double> {
    override fun execute(vararg args: Double?) = println(args.filterNotNull().sum())

    override fun cancel() = TODO("Not yet implemented")

    override fun name(): String = "sum"
}

class SortNumbersCommand : Command<Int> {
    override fun execute(vararg args: Int?) = println(args.filterNotNull().sorted())

    override fun cancel() = TODO("Not yet implemented")

    override fun name(): String = "sort"
}

fun main() {
    val shell = Shell()
    shell.launch(SumNumbersCommand(), 2.5, 3.5, 8.4)
    shell.launch(SortNumbersCommand(), 3, 1, 2)
}