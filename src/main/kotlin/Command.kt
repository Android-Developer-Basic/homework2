package ru.otus.homework2
/*
Попытка реализации Паттерна "Command"
* */

// Define a command interface
interface Command {
    fun execute()
}
// Concrete command
class Kettle(private val smartHome: SmartHome) : Command {
    override fun execute() {
        smartHome.boilWater()
    }
}
// Concrete command
class Toaster(private val smartHome: SmartHome) : Command {
    override fun execute() {
        smartHome.toastBread()
    }
}
// SmartHome as a Receiver
class SmartHome {
    fun boilWater() {
        println("SmartHome is boiling water")
    }

    fun toastBread() {
        println("SmartHome is toasting bread")
    }
}
// Define an invoker
class ControlPanel {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun executeCommand() {
        command?.execute()
    }
}

fun main() {
    val smartHome = SmartHome()

    val kettleCommand = Kettle(smartHome)
    val toasterCommand = Toaster(smartHome)

    val controlPanel = ControlPanel()

    controlPanel.setCommand(kettleCommand)
    controlPanel.executeCommand()

    controlPanel.setCommand(toasterCommand)
    controlPanel.executeCommand()
}