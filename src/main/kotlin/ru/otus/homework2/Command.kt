package ru.otus.homework2

interface Command {
    fun execute()
}
class Text {
    fun print() {
        println("Привет")
    }
    fun print2() {
        println("Пока")
    }
}
class ObjText(private val string: Text) : Command {
    override fun execute() {
        string.print()
    }
}
class ObjText2(private val string: Text) : Command {
    override fun execute() {
        string.print2()
    }
}
class Invoker (var command: Command) {
    fun doExecute() {
        command.execute()
    }
}
fun main() {
    val text = Text()
    val objText = ObjText(text)
    val objText2 = ObjText2(text)
    val invoker = Invoker(objText)
    invoker.doExecute()
    invoker.command = objText2
    invoker.doExecute()
}