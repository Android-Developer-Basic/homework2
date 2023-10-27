package ru.otus.homework.team

class LightOffCommand (private val light: Light) : Command {
    override fun execute() {
        light.turnOff()
    }
}