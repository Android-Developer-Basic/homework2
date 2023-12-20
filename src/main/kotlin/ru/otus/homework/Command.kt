package ru.otus.homework

interface Command {
    fun execute()
}

class Light {
    fun lightOn() {
        println("Light is ON")
    }
    fun lightOff() {
        println("Light is OFF")
    }
}

class CommandTurnOn (private var light: Light) : Command {
    override fun execute() {
        light.lightOn()
    }
}

class CommandTurnOff (private var light: Light) : Command {
    override fun execute() {
        light.lightOff()
    }
}

class RemoteControl(private val command: Command) {
    fun pressButton() {
        command.execute()
    }
}

fun main() {
    val light = Light()
    val lightOnCommand = CommandTurnOn(light)
    val lightOffCommand = CommandTurnOff(light)
    val remote = RemoteControl(lightOnCommand)
    remote.pressButton()
    val remote2 = RemoteControl(lightOffCommand)
    remote2.pressButton()
}