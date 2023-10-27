package ru.otus.homework.team

class LightOnCommand (private val light: Light) : Command {
    override fun execute() {
        light.turnOn()
    }
}