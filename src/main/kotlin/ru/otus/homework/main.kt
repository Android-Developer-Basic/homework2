package ru.otus.homework

object SingletonExample {
    val foo : String
    init {
        println("Singleton Example init")
        foo = "foo"
    }
}

open class DecoratorClass(val foo: String="") {
    open fun Display() {
        println(foo)
    }
}

class DecoratorExample(val decorator: DecoratorClass):DecoratorClass(decorator.foo) {
    override fun Display() {
        println("Decorate it:")
        decorator.Display()
    }
}

interface Command {
    fun run()
}

class PrintCommand:Command {
    val cmd = "Print"
    override fun run() {
        println(cmd)
    }
}

class HelpCommand:Command {
    val cmd = "Help"
    override fun run() {
        println(cmd)
    }
}

class CommandRunner {
    fun executeCommand(command: Command) {
        command.run()
    }
}

class CommandList:Command {
    private val execs = mutableListOf<Command>()

    fun first(command: Command): CommandList {
        execs.clear()
        execs.add(command)
        return this
    }

    fun then(command: Command): CommandList {
        execs.add(command)
        return this
    }

    override fun run() {
        execs.forEach {exec ->
            exec.run()
        }
    }
}

fun main() {
    println("=====> Синглтон с ленивой инициализацией")
    println("Foo value (first call): ${SingletonExample.foo}")
    println("Foo value (second call): ${SingletonExample.foo}")
    println()

    println("====> Декоратор")
    val de = DecoratorExample(DecoratorClass("Example"))
    de.Display()
    println()

    println("====> Команда")
    val cmd=CommandRunner()
    cmd.executeCommand(HelpCommand())
    cmd.executeCommand(PrintCommand())
    println()

    println("====> Билдер")
    val list=CommandList().first(HelpCommand()).then(PrintCommand())
    list.run()
}
