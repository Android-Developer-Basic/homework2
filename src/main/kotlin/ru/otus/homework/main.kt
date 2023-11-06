package ru.otus.homework

object SingletonExample {
    val foo : String
    init {
        println("Singleton Example init")
        foo = "foo"
    }
}

class SingletonExampleClass() {
    var foo: String?=null

    init {
        println("Singleton Example Class init")
        this.foo = "foo"
    }
    companion object {
        val instance:SingletonExampleClass by lazy {
            SingletonExampleClass()
        }
        fun getSInstance():SingletonExampleClass {
            return instance
        }
    }

}

open class DecoratorClass(val foo: String="") {
    open fun display() {
        println(foo)
    }
}

class DecoratorExample(val decorator: DecoratorClass):DecoratorClass(decorator.foo) {
    override fun display() {
        println("Decorate it:")
        decorator.display()
    }
}

interface Command {
    fun run()
}

class PrintCommand:Command {
    val cmd = "Print"
    override fun run() {
        print(cmd)
    }
}

class HelpCommand:Command {
    val cmd = "Help"
    override fun run() {
        print(cmd)
    }
}

class CommandRunner {
    fun executeCommand(command: Command) {
        command.run()
        println()
    }
}

class CommandList(private var prefix: String, private var suffix: String) :Command {

    data class Builder(
        var prefix: String? = null,
        var suffix: String? = null
    ) {
        fun prefix(prefix: String) = apply {this.prefix=prefix}
        fun suffix(suffix: String) = apply {this.suffix=suffix}
        fun build() = CommandList(prefix ?: "",suffix ?: "")
    }
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
            print(prefix)
            exec.run()
            println(suffix)
        }
    }
}

fun main() {
    println("=====> Синглтон с ленивой инициализацией")
    val instance = SingletonExampleClass.getSInstance()
    println("Foo value (first call): ${instance.foo}")
    println("Foo value (second call): ${instance.foo}")
    println()

    println("====> Декоратор")
    val de = DecoratorExample(DecoratorClass("Example"))
    de.display()
    println()

    println("====> Команда")
    val cmd=CommandRunner()
    cmd.executeCommand(HelpCommand())
    cmd.executeCommand(PrintCommand())
    println()

    println("====> Билдер")
    val list=CommandList.Builder().prefix("prefix->").suffix("<-suffix").build()
    list.first(HelpCommand()).then(PrintCommand())
    list.run()
}
