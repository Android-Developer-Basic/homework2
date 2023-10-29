package ru.otus.patterns

interface Command {
    fun execute()
}

data class AddCommand(val x: Int, val y: Int) : Command {
    override fun execute() {
        val result = x + y
        println("+($x, $y) => $result")

    }
}

data class SubCommand(val x: Int, val y: Int) : Command {
    override fun execute() {
        val result = x - y
        println("-($x, $y) => $result")
    }
}

fun executeCommand(command: Command) {
    command.execute()
}

fun runCommands(vararg commands: Command) {
    for (command in commands) {
        executeCommand(command)
    }
}

fun main() {
    runCommands(
        AddCommand(1, 2),
        SubCommand(4, 7)
    )
}

